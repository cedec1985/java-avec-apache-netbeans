package fr.eni.gestionnotes.entities;

import fr.eni.gestionnotes.entities.Etudiants;
import fr.eni.gestionnotes.entities.Modules;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-11-11T17:50:59")
@StaticMetamodel(Notes.class)
public class Notes_ { 

    public static volatile SingularAttribute<Notes, BigDecimal> note;
    public static volatile SingularAttribute<Notes, Modules> idModule;
    public static volatile SingularAttribute<Notes, Long> idNote;
    public static volatile SingularAttribute<Notes, Etudiants> idEtudiant;

}