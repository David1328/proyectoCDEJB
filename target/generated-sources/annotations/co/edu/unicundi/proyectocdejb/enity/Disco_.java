package co.edu.unicundi.proyectocdejb.enity;

import co.edu.unicundi.proyectocdejb.enity.Cantante;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-11T22:07:09")
@StaticMetamodel(Disco.class)
public class Disco_ { 

    public static volatile SingularAttribute<Disco, Integer> precio;
    public static volatile SingularAttribute<Disco, String> nombre_disco;
    public static volatile SingularAttribute<Disco, Integer> cantidad_discos;
    public static volatile SingularAttribute<Disco, Cantante> cantante;
    public static volatile SingularAttribute<Disco, String> ano_lanzamiento;
    public static volatile SingularAttribute<Disco, String> formato;
    public static volatile SingularAttribute<Disco, String> compania_productora;
    public static volatile SingularAttribute<Disco, Integer> id_disco;

}