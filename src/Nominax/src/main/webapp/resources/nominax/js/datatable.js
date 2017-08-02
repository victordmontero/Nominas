/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $(".datatable").dataTable({
        language: {
            paginate: {
                next: "Siguiente",
                previous: "Anterior"
            },
            search: "Buscar",
            info: "Mostrando _START_ a _END_ de _TOTAL_ registros",
            infoEmpty: "Mostrando 0 a 0 de 0 registros",
            lengthMenu: "Mostrar _MENU_ registros",
            emptyTable: "No hay datos disponibles en la tabla"
        }
    });
});
