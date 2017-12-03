/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package cobajpa;

import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.sessions.factories.SessionFactory;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class control {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("cobaJPAPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction entr = em.getTransaction();
    Divisi d = new Divisi();

    public void insert(String nama_divisi, String job_desc) {

        try {
            entr.begin();
            d.setNamadivisi(nama_divisi);
            d.setJobdesc(job_desc);
            em.persist(d);
            entr.commit();
            System.out.println("1 record berhasil ditambahkan ke database");
        } catch (Exception e) {
            System.out.println("zonkkk  " + e.getMessage());
        }

    }

    public void update(int id_divisi, String nama_divisi, String job_desc) {

        try {

            entr.begin();
            d = em.find(Divisi.class, id_divisi);
            d.setNamadivisi(nama_divisi);
            d.setJobdesc(job_desc);
            em.persist(d);
            entr.commit();
            System.out.println("1 record berhasil update");
        } catch (Exception e) {
            System.out.println("zonk  " + e.getMessage());
        }
    }

    public void delete(int id_divisi) {
        try {
            entr.begin();
            d = em.find(Divisi.class, id_divisi);
            em.remove(d);
            entr.commit();
            System.out.println("hilang...................");
        } catch (Exception e) {
            System.out.println("zonk  " + e.getMessage());
        }
    }
public void select()
{
try {
entr.begin();
Query query = em.createNamedQuery("Divisi.findAll");
List stList = query.getResultList();
Iterator stIterator = stList.iterator();
while (stIterator.hasNext())
{
Divisi d = (Divisi) stIterator.next();
    int id = d.getIddivisi();
    String nama = d.getNamadivisi();
    String job = d.getJobdesc();

               System.out.println(id+nama+job);

    
    
}
entr.commit();
} catch (Exception e) 
{
System.out.println(e.getMessage());
} finally {
em.close();
        }     
}


public void count_id()
{
try {
entr.begin();
Query query = em.createQuery("SELECT max(d.iddivisi)as id FROM Divisi d");
List stList = query.getResultList();
Iterator stIterator = stList.iterator();
while (stIterator.hasNext())
{
Divisi d = (Divisi) stIterator.next();
    int id = d.getIddivisi();
System.out.println(id);    
}
entr.commit();
} catch (Exception e) 
{
System.out.println(e.getMessage());
} finally {
em.close();
        }     
}

//  public  void selec() 
//  {
//        List<Divisi> div = findAllDivisi();
//        for (Divisi e : div) 
//        {
//            System.out.println("Found Divisi: " + e);
//        }
//    }
//
//    public List<Divisi> findAllDivisi()
//    {
//        Query query = em.createNamedQuery("Divisi.findAll");
//        return query.getResultList();
//    }
}
