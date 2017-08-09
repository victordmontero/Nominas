/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import edu.unapec.nomina.dao.IRepositorio;
import edu.unapec.nomina.dao.RepositorioDepartamentos;
import edu.unapec.nomina.modelos.Departamentos;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author phenom
 */
@Controller
@RequestMapping(value = "/reporte")
public class ReporteController {

    IRepositorio<Departamentos> repoDep;
    Connection conn;

    @Autowired
    public ReporteController(RepositorioDepartamentos dep, BasicDataSource conn) {
        try {
            this.conn = conn.getConnection();
            repoDep = dep;
        } catch (Exception e) {

        }
    }

    @RequestMapping(value = {"/"})
    public ModelAndView Generar() {
        try {
            ModelAndView mv = new ModelAndView("reporte/generar");
            mv.addObject("departamentos", repoDep.ObtenerTodos());
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @RequestMapping(value = {"/generar"})
    @ResponseBody
    public void Generar(HttpServletResponse response, @RequestParam Integer idDep) throws JRException, IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/reportes/Reporte.jasper");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("DepId", idDep);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=ReporteNomina.pdf");

        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
