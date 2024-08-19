package org.me.estadistica.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Alumno {

    private static final String FILLER_ZERO = "0";
    private static final String FILLER_SPACE = " ";

    @NonNull
    final String fechaFallecimiento = "00000000";
    @NonNull
    final String filler = "           ";

    @NonNull
    String tipoDocumento, numeroDocumento, apellidoNombre, fechaNacimiento;

    String calle, numero, piso, depto, codigoPostal, localidad, codigoProvincia,escuelaCueAnexo, anio, seccion, titulacion, estado;

    char sexo;

    public Alumno(String tipoDocumento, String numeroDocumento, String apellidoNombre,
                  String sexo, String fechaNacimiento,
                  String calle, String numero, String piso,
                  String depto, String codigoPostal, String localidad, String codigoProvincia) {
        this.tipoDocumento = this.agregarCerosAdelante(tipoDocumento, 2);
        this.numeroDocumento = this.agregarCerosAdelante(numeroDocumento, 8);
        this.apellidoNombre = this.agregarEspaciosAlFinal(apellidoNombre, 40);
        this.sexo = sexo.toUpperCase().charAt(0);
        this.fechaNacimiento = this.agregarCerosAdelante(formatearFecha(fechaNacimiento),8);
        this.calle = this.agregarEspaciosAlFinal(calle, 40);
        this.numero = this.agregarEspaciosAlFinal(numero, 5);
        this.piso = this.agregarEspaciosAlFinal(piso, 2);
        this.depto = this.agregarEspaciosAlFinal(depto, 4);
        this.codigoPostal = this.agregarCerosAdelante(codigoPostal, 4);
        this.localidad = this.agregarEspaciosAlFinal(localidad, 25);
        this.codigoProvincia = this.agregarCerosAdelante(codigoProvincia, 2);
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = this.agregarCerosAdelante(tipoDocumento, 2);
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = this.agregarCerosAdelante(numeroDocumento, 8);
    }

    public void setApellidoNombre(String apellidoNombre) {
        this.apellidoNombre = this.agregarEspaciosAlFinal(apellidoNombre, 40);
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = this.agregarCerosAdelante(formatearFecha(fechaNacimiento),8);
    }

    public void setCalle(String calle) {
        this.calle = this.agregarEspaciosAlFinal(calle, 40);
    }

    public void setNumero(String numero) {
        this.numero = this.agregarEspaciosAlFinal(numero, 5);
    }

    public void setPiso(String piso) {
        this.piso = this.agregarEspaciosAlFinal(piso, 2);
    }

    public void setDepto(String depto) {
        this.depto = this.agregarEspaciosAlFinal(depto, 4);
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = this.agregarCerosAdelante(codigoPostal, 4);
    }

    public void setLocalidad(String localidad) {
        this.localidad = this.agregarEspaciosAlFinal(localidad, 25);
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = this.agregarCerosAdelante(codigoProvincia, 2);
    }

    public void setEscuelaCueAnexo(String escuelaCueAnexo) {
        this.escuelaCueAnexo = escuelaCueAnexo;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo.toUpperCase().charAt(0);
    }

    public String agregarCerosAdelante(String cadena, int longitudMaxima){
        for (int i = cadena.length(); i < longitudMaxima; i++) {
                cadena = FILLER_ZERO + cadena;
        }
        return cadena;
    }

    public String agregarEspaciosAlFinal(String cadena, int longitudMaxima){
        for (int i = cadena.length(); i < longitudMaxima; i++) {
            cadena = cadena.concat(FILLER_SPACE);
        }
        return cadena;
    }

    public String formatearFecha(String fechaInput){
        String fecha = fechaInput.replace("/", "-");
        String pattern = "dd-MM-yyyy";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate date = LocalDate.parse(fecha, formatter);

        return  date.toString().replace("-","");

    }

    @Override
    public String toString() {
        return this.tipoDocumento+this.numeroDocumento+this.apellidoNombre+this.sexo
                +this.fechaNacimiento+this.fechaFallecimiento+this.calle+this.numero
                +this.piso+this.depto+this.codigoPostal+this.localidad
                +this.codigoProvincia+this.filler;
    }
}
