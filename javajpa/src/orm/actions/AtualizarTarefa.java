package orm.actions;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Tarefa;

public class AtualizarTarefa {
	public static void main(String[] args) {
		
		Tarefa tarefa1 = new Tarefa();
		
		tarefa1.setId(2L);
		tarefa1.setDescricao("Estudar um pouco Java");
		tarefa1.setFinalizado(true);
		tarefa1.setDataFinalizacao(Calendar.getInstance());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();

		
//		//tarefa1.setId(1L);
//		tarefa1 = manager.find(Tarefa.class, 2L);
		
		manager.getTransaction().begin(); //Inicializar a transação
		manager.merge(tarefa1); //linha que faz o hibernate excluir um objeto no banco
		manager.getTransaction().commit();  //Encerramento da transação
		
		manager.close();
		factory.close();
	}
}
