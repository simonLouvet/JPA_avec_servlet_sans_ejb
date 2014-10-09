package org.imie.jpaTP;

import java.io.IOException;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import model.Titi;

/**
 * Servlet implementation class TP1
 */
@WebServlet("/TP1")
public class TP1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@PersistenceUnit(unitName = "jpaPU")
	private EntityManagerFactory emf;
	
	@Resource
 	private UserTransaction tx ;
	
	@PersistenceContext(unitName = "jpaPU2")
	private EntityManager em;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TP1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager entityManager = emf.createEntityManager();
		//Titi titi = entityManager.find(Titi.class, 178);
		Titi titi = new Titi();
		EntityTransaction transaction =null;
		try{
			//transaction = em.getTransaction();
			//transaction.begin();
			tx.begin();
			titi.setTexte("allo");
			em.persist(titi);
			//transaction.commit();
			tx.commit();
		}catch(PersistenceException e){
			throw e;
		}catch(Exception e){
			try {
				tx.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);	
		}finally{
//			if (transaction.isActive()){
//				transaction.rollback();
//			}

			//entityManager.close();
		}
		
		response.getWriter().println(titi.getTexte());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
