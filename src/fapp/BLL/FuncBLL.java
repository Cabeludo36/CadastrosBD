/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fapp.BLL;
import fapp.DAL.*;
import fapp.DTO.*;

/**
 *
 * @author brepi
 */
public class FuncBLL {
    public boolean addFunc(FuncDTO func){
        FuncDAL add = new FuncDAL();
        return add.addFunc(func);
    }
}
