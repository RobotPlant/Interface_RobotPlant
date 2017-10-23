package com.RobotPlant.JRUtil;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class ReportsFactory {

    public void createReport(String caminho, String nomeArquivo) {
        List<Object> lista = new ArrayList<>();
        try {
            JasperPrint print = JasperFillManager.fillReport(ReportsFactory.compilePath(caminho, nomeArquivo), null, new JRBeanCollectionDataSource(lista));
            ReportsFactory.exportReport(print);
            ReportsFactory.viewReport(print);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }

    }

    private static JasperReport compilePath(String caminho, String nomeArquivo) {
        JasperReport report;
        try {
            report = JasperCompileManager.compileReport(caminho+nomeArquivo);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
        return report;
    }

    private static void exportReport(JasperPrint print) {

        try {
            JasperExportManager.exportReportToPdfFile(print, "/home/joaojunior/Relatorio.pdf");
        } catch (JRException e) {
            throw new RuntimeException(e);
        }

    }

    private static void viewReport(JasperPrint print) {

        JasperViewer viewReport = new JasperViewer(print);
        viewReport.setVisible(true);
    }

}
