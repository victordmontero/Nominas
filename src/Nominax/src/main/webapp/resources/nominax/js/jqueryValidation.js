/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $(".departamentoVal").validate({
        rules: {
            nombre: {
                required: true,
                maxlength: 50
            },
            ubicacion: {
                required: true,
                maxlength: 25
            }
        }

    });

    $(".puestoVal").validate({
        rules: {
            descripcion: {
                required: true,
                maxlength: 50
            },
            riesgo: {
                required: true,
                maxlength: 10
            },
            salarioMin: {
                required: true,
                min: 0,
                salarioMenor: "salarioMax"
            },
            salarioMax: {
                required: true,
                min: 0,
                salarioMayor: "salarioMin"
            }
        }
    });

    $(".nominaVal").validate({
        rules: {
            descripcion: {
                required: true,
                maxlength: 50
            }
        }
    });

    $(".usuarioVal").validate({
        rules: {
            nombre: {
                required: true,
                maxlength: 25
            },
            password: {
                required: true,
                maxlength: 15
            },
            repassword: {
                equalTo: "#password"
            },
            roleses: "required"
        }
    });

    $(".tidVal").validate({
        rules: {
            descripcion: {
                required: true,
                maxlength: 50
            },
            tipo: "required"
        }
    });

    $(".transaccionVal").validate({
        rules: {
            tipoTransaccion: {
                required: true,
                maxlength: 10
            },
            "empleados.idEmpleado": "required",
            "tipoIngresoDeduccion.idTipoIngresoDeduccion": "required",
            monto: "required"
        }
    });

    $(".empleadoVal").validate({
        rules: {
            nombre: {
                required: true,
                maxlength: 80
            },
            "departamentos.idDepartamento": "required",
            "nominas.idNomina": "required",
            "puestos.idPuesto": "required",
            salario: {
                required: true,
                min: 0
            },
            cedula: "modulo10"
        }
    });

    jQuery.validator.addMethod("salarioMenor", function (value, element, params) {
        var otro = $("input[name='" + params + "']").val();
        console.log("otro = " + otro);
        return this.optional(element) || parseInt(value, 10) < parseInt(otro, 10);
    }, "Salario minimo debe ser menor que Salario maximo");

    jQuery.validator.addMethod("salarioMayor", function (value, element, params) {
        var otro = $("input[name='" + params + "']").val();
        console.log("otro = " + otro);
        return this.optional(element) || parseInt(value, 10) > parseInt(otro, 10);
    }, "Salario maximo debe ser mayor que Salario minimo");

    jQuery.validator.addMethod("modulo10", function (cedula, element, params) {

        Array.from(cedula).every(function (val, index, arr) {
            return !isNaN(val);
        });

        cedula = cedula.replace("-", "").trim();

        var temp = "";
        if (cedula.length === 11) {
            for (var i = 0; i < cedula.length; i++) {
                temp += parseInt(cedula[i]) * (i % 2 + 1);
            }
        } else
            return false;

        console.log("temp " + temp);

        var sigma = Array.from(temp).reduce(function (sum, value) {
            return sum + parseInt(value);
        });

        return Math.abs(10 - sigma % 10) === parseInt(cedula[cedula.length - 1]);

    }, "Ingrese una cedula valida");

});

