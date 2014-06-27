package mio.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fideuram.crm.model.Canale;
import com.fideuram.crm.model.Comunicazione;
import com.fideuram.crm.model.GruppoCRM;
import com.fideuram.crm.model.TipoComunicazione;
import com.fideuram.crm.model.UtenteCRM;

@Service
public class MioServiceImpl implements MioService{
	
	@PersistenceContext(unitName="mioEmf")
    private EntityManager em;

	
	@Transactional
	public void insertCom() throws Exception{
		
		
		Canale can = new Canale();
		
		em.persist(can);
		//UtenteCRM ass = em.getReference(UtenteCRM.class, 3786);
		//Canale canale = em.getReference(Canale.class, 90);
		//GruppoCRM gLav = em.getReference(GruppoCRM.class, 3478);
		//TipoComunicazione tipoCom = em.getReference(TipoComunicazione.class, 176);
		
		/*Comunicazione com1 = new Comunicazione();			
		com1.setAssegnatario(ass);
		com1.setOwner(ass);
		com1.setDirezioneId(1);
		com1.setCreatore(ass);
		com1.setCanale(canale);
		com1.setGruppoLavorazione(gLav);
		com1.setTipoComunicazione(tipoCom);
		em.persist(com1);*/
	}
	
	public static void main(String[] aa) {
		ClassPathXmlApplicationContext context = null;
		try{
			context = new ClassPathXmlApplicationContext("mio.services.context.xml");
			MioService serv = context.getBean(MioService.class);
			serv.insertCom();
			
		}catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}finally{
			context.close();
		}
		System.exit(0);
	}
	
	
}
