package com.example.demo.entity;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="tb_empleado")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpleadoEntity {
	
	@Id
    @Column(name = "dni_empleado", columnDefinition = "CHAR(8)")
    private String dniEmpleado;

    @Column(name = "nombre_empleado", columnDefinition = "VARCHAR(45)")
    private String nombreEmpleado;
    
    @Column(name = "apellido_empleado", columnDefinition = "VARCHAR(45)")
    private String apellidoEmpleado;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "direccion", columnDefinition = "VARCHAR(45)")
    private String direccion;
    
    @Column (name = "correo",nullable = false, unique = true,columnDefinition = "VARCHAR(45)")
	private String correo;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    private AreaEntity areaEntity;

}
