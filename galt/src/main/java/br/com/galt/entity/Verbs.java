package br.com.galt.entity;




import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table // optional
public class Verbs {

    @Id
    private Integer id;
    private String verb;
    private String past_tense;
    private String past_participle;
    private String pt_br;
   

}




