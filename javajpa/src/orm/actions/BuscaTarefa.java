package orm.actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Tarefa;

public class BuscaTarefa {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();

		// Query em JPQL que é traduzida para o SQL do banco definido persistence.xml
		javax.persistence.Query query = manager
				.createQuery("select t from Tarefa as t where t.finalizado =:paramFinalizado");
		query.setParameter("paramFinalizado", true);

		List<Tarefa> lista = query.getResultList();

		for (Tarefa t : lista) {
			System.out.println(t.getDescricao());

		}
		manager.close();
		factory.close();
	}
}
