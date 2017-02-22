package eu.grmdev.l4z.quiz.server.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "p_answers")
@Data
public class PossibleAnswer {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "f_answer")
	private String answer;
	@Column(name = "f_type")
	private AnswerType answerType;
}
