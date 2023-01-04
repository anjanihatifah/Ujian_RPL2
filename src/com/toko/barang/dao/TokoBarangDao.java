/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toko.barang.dao;

import com.toko.barang.model.TokoBarang;
import java.util.List;

/**
 *
 * @author mcojaya
 */
public interface TokoBarangDao {
    public void save(TokoBarang tokobarang);
    public void update(TokoBarang tokobarang);
    public void delete(TokoBarang tokobarang);
    public TokoBarang get(String kd_barang);
    public List<TokoBarang> getList();
}
