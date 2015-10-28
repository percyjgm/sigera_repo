/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigera.controlador;

import com.sigera.entidad.Modulo;
import com.sigera.entidad.Perfil;
import com.sigera.entidad.Permiso;
import com.sigera.paginacion.Paginador;
import com.sigera.servicio.IPerfilServicio;
import com.sigera.utils.Utilitario;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.component.export.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrador
 */
@Component(value = "perfilControlador")
@Scope("view")
public class PerfilControlador implements Serializable {
    private static final long serialVersionUID = -8360455816950681831L;

    @Autowired
    @Qualifier("perfilPaginador")
    Paginador<Perfil> perfilPaginador;
    
    @Autowired
    IPerfilServicio perfilServicio;
    private List<Modulo> modulos;
    List<Permiso> permisos;

    Perfil perfil;

    public PerfilControlador() {

    }

    public void initLista() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            perfilPaginador.initPaginador();
        }
    }

    public void initCreate() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            perfil = new Perfil();
            permisos = new ArrayList();
            modulos = perfilServicio.obtenerModulos();
            inicializarPermisos(modulos);
        }
    }

    private void inicializarPermisos(List<Modulo> modulos) {
        for (int i = 0; i < modulos.size(); i++) {
            Permiso permiso = new Permiso();
            permiso.setModulo(modulos.get(i));
            permisos.add(permiso);
        }
    }

    public void initUpdate() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            Object value = Utilitario.getFlash("idPerfil");
            if (value == null) {
                Utilitario.redireccionarJSF(FacesContext.getCurrentInstance(), "/views/perfil/list.xhtml");
                return;
            }
            perfil = perfilServicio.obtenerPerfilId(Integer.valueOf(value.toString()));
            permisos = perfilServicio.obtenerPermisosPorPerfil(perfil.getId());
        }
    }

    public String irtActualizar(Integer id) {
        Utilitario.putFlash("idPerfil", id);
        return "update.xhtml?faces-redirect=true";
    }

    public void registrarPerfil() {
        perfilServicio.registrarPerfil(perfil, permisos);
        limpiar();
    }

    public void actualizarPerfil() {
        perfilServicio.actualizarPerfil(perfil, permisos);
    }

    private void limpiar() {
        perfil = new Perfil();
        permisos = new ArrayList<>();
        modulos = perfilServicio.obtenerModulos();
        inicializarPermisos(modulos);
    }
    
    public void exportarData(){
        List<Perfil> data = perfilPaginador.obtenerListaCompleta();
//        ExcelExporter exporter = new ExcelExporter(Perfil.class,data);
//        exporter.agregarHeader("Perfil");
//        exporter.crearDocumento();
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        ExternalContext externalContext = facesContext.getExternalContext();
//        externalContext = ExcelExporter.getResponseContent(externalContext,"lista_perfiles");
//        try {
//            OutputStream outputStream = externalContext.getResponseOutputStream();
//            exporter.exportarDocumento(outputStream);
//            externalContext.setResponseStatus(200);
//            externalContext.responseFlushBuffer();
//            facesContext.responseComplete();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    
    public void capturarPermiso(Integer id){
        perfil = perfilServicio.obtenerPerfilesPorPermisos(id);
    }
    
    public void eliminarperfil(){
       perfilServicio.eliminarPerfil(perfil);
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    public Paginador<Perfil> getPerfilPaginador() {
        return perfilPaginador;
    }

    public void setPerfilPaginador(Paginador<Perfil> perfilPaginador) {
        this.perfilPaginador = perfilPaginador;
    }

}
