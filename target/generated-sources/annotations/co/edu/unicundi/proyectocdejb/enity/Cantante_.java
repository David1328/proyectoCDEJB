package co.edu.unicundi.proyectocdejb.enity;

import co.edu.unicundi.proyectocdejb.enity.Disco;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-02T14:28:53")
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-02T15:16:52")
@StaticMetamodel(Cantante.class)
public class Cantante_ { 

    public static volatile SingularAttribute<Cantante, Integer> idCantante;
    public static volatile SingularAttribute<Cantante, String> categoria;
    public static volatile SingularAttribute<Cantante, String> nick_name;
    public static volatile ListAttribute<Cantante, Disco> discos;
    public static volatile SingularAttribute<Cantante, String> nombre;

}
