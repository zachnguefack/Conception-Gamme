package org.sid.offregame.services;

import org.sid.offregame.entities.*;
import org.sid.offregame.exceptions.CategoryParametreDecolletageNotFindException;
import org.sid.offregame.exceptions.TasKCategoryNotFindException;
import org.sid.offregame.exceptions.TasKNotFindException;

import java.util.List;

public interface OffreGameService {

    Client saveClient(Client client);
    DefaultParameter saveDefaultParameter(DefaultParameter defaultParameter);
    Piece savePiece(Piece piece);
    Task getTaskById(String id);
    OtherTask saveOtherTask(String name, boolean status, int numero, double tempsCycleDeBaseSecond,
                            double tempsDeReglageHeur, double tempsDeCycleCalculerSecond, Long categoryId) throws TasKCategoryNotFindException;
    List<TaskCategory> listCategory();
    void updateTask(String id, boolean status);
    TaskCategory getTaskCategoryByName(String name);
    Task findTaskWithHighestNumber();
    void decrementTaskNumbers(int numero);
    List<Task> findByStatusTrueOrderByNumeroAsc();
    List<Task> findByTaskCategory(TaskCategory taskCategory);
    Task maxNumero ();
    void updateTaskNumber(String id,Integer nouveauNumero);
    void updateTasksStatusAndNumber();
    TaskCategory saveTaskCategory(TaskCategory taskCategory);
    SubOtherTask saveSubOtherTask(boolean status,int numeroSequence, String name, double tempsDeReglage,double tempsDeProduction, String taskId) throws TasKNotFindException;
    TaskPrecisionParameter saveTaskPrecisionParameter(boolean status,double tempsOuvertureMin,double nombrePieceParHeure
    ,double nombrePieceParHeureApresDeduction, double tempsDeCycleGammeEnSeconde, double pourMilParPcsEnHeure,
                                                      double tauxDeRendment, double efficiencePoste,double calculInversePiecesParJour,
                                                      double piecesParJour,String taskId) throws TasKNotFindException;
    TaskTimeParameter saveTaskTimeParameter(boolean status, String name, double nombreHeure, double tempsMinParHeure,
                                            double totalTimeEnMin,double proportionTemps, String taskId) throws TasKNotFindException;
    ComplexTask saveComplexTask(String name, boolean status, int numero);
    CategoryParametreDecolletage saveCategoryParametreDecolletage(String name, String complexTaskId) throws TasKNotFindException;
    ParametreDecolletage saveParametreDecolletage(String name, boolean status,double tempsDeMontage, double coutMoyenOutils,Long categoryId) throws CategoryParametreDecolletageNotFindException;


    Synthesis saveSynthesis(Synthesis synthesis);
}
