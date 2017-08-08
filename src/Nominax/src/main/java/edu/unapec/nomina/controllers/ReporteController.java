/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author phenom
 */
@Controller
@RequestMapping(value = "/reporte")
public class ReporteController {

    public ReporteController() {
    }

    @RequestMapping(value = {"/", "/index"})
    @ResponseBody
    public void Generar(HttpServletResponse response) throws JRException, IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/reporte.jasper");
        Map<String,Object> params = new HashMap<String, Object>();
        JasperReport jasperReport = (JasperReport)JRLoader.loadObject(inputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params);
        
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");
        
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
