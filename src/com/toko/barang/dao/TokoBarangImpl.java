/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toko.barang.dao;

import com.toko.barang.model.TokoBarang;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author mcojaya
 */
public class TokoBarangImpl implements TokoBarangDao {
    private final SessionFactory sessionFactory;

    public TokoBarangImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(TokoBarang tokobarang) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(tokobarang);
            session.getTransaction().commit();
        }catch(Exception e){
            System.err.print("Tidak Dapat Menyimpan Data Barang");
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(TokoBarang tokobarang) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(tokobarang);
            session.getTransaction().commit();
        }catch(Exception e){
            System.err.print("Tidak Dapat Mengupdate Data Barang");
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(TokoBarang tokobarang) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(tokobarang);
            session.getTransaction().commit();
        }catch(Exception e){
            System.err.print("Tidak Dapat Menghapus Data Barang");
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TokoBarang get(String kd_barang) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            TokoBarang tokobarang = (TokoBarang) session.get(TokoBarang.class, kd_barang);
            session.getTransaction().commit();
            return tokobarang;
        }catch(Exception e){
            System.err.print("Tidak Dapat Menampilkan Data Barang");
            session.getTransaction().rollback();
            return null;
        }
        finally{
            session.close();
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TokoBarang> getList() {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            List<TokoBarang> listbarang = session.createCriteria(TokoBarang.class).list();
            session.getTransaction().commit();
            return listbarang;
        }catch(Exception e){
            System.err.print("Tidak Ada List Barang");
            session.getTransaction().rollback();
            return null;
        }
        finally{
            session.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
