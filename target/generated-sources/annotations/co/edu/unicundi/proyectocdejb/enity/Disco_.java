package co.edu.unicundi.proyectocdejb.enity;

import co.edu.unicundi.proyectocdejb.enity.Cantante;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-09T13:02:40")
@StaticMetamodel(Disco.class)
public class Disco_ { 

    public static volatile SingularAttribute<Disco, String> nick_artistas_secundarios;
    public static volatile SingularAttribute<Disco, Cantante> cantante;
    public static volatile SingularAttribute<Disco, String> ano_lanzamiento;
    public static volatile SingularAttribute<Disco, String> formato;
    public static volatile SingularAttribute<Disco, String> compania_productora;
    public static volatile SingularAttribute<Disco, Integer> cantidad;
    public static volatile SingularAttribute<Disco, Integer> id_formato;
    public static volatile SingularAttribute<Disco, String> nombre_album;
    public static volatile SingularAttribute<Disco, Integer> id_disco;

}