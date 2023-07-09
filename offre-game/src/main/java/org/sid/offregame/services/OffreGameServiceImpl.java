package org.sid.offregame.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.offregame.dao.*;
import org.sid.offregame.entities.*;
import org.sid.offregame.exceptions.CategoryParametreDecolletageNotFindException;
import org.sid.offregame.exceptions.TasKCategoryNotFindException;
import org.sid.offregame.exceptions.TasKNotFindException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class OffreGameServiceImpl implements OffreGameService{

    private SubOtherTaskRepository subOtherTaskRepository;
    private TaskCategoryRepository taskCategoryRepository;
    private TaskRepository taskRepository;
    private TaskPrecisionParameterRepository taskPrecisionParameterRepository;
    private TaskTimeParameterRepository taskTimeParameterRepository;
    private ParametreDecolletageRepository parametreDecolletageRepository;
    private CategoryParametreDecolletageRepository categoryParametreDecolletageRepository;


    public TaskCategory saveTaskCategory(TaskCategory taskCategory) {
        return taskCategoryRepository.save(taskCategory);
    }


    public SubOtherTask saveSubOtherTask(SubOtherTask subOtherTask) {
        return subOtherTaskRepository.save(subOtherTask);
    }

    public TaskPrecisionParameter saveTaskPrecisionParameter(boolean status, double tempsOuvertureMin, double nombrePieceParHeure,
                                                             double nombrePieceParHeureApresDeduction, double tempsDeCycleGammeEnSeconde,
                                                             double pourMilParPcsEnHeure, double tauxDeRendment, double efficiencePoste,
                                                             double calculInversePiecesParJour, double piecesParJour, String taskId) throws TasKNotFindException {

        Task task = taskRepository.findById(taskId).orElse(null);
        if(task == null){
            throw  new TasKNotFindException("Task Not Find!");
        }
        TaskPrecisionParameter precisionParameter = new TaskPrecisionParameter();
        precisionParameter.setStatus(status);
        precisionParameter.setTempsOuvertureMin(tempsOuvertureMin);
        precisionParameter.setNombrePieceParHeure(nombrePieceParHeure);
        precisionParameter.setNombrePieceParHeureApresDeduction(nombrePieceParHeureApresDeduction);
        precisionParameter.setTempsDeCycleGammeEnSeconde(tempsDeCycleGammeEnSeconde);
        precisionParameter.setPourMilParPcsEnHeure(pourMilParPcsEnHeure);
        precisionParameter.setTauxDeRendment(tauxDeRendment);
        precisionParameter.setEfficiencePoste(efficiencePoste);
        precisionParameter.setCalculInversePiecesParJour(calculInversePiecesParJour);
        precisionParameter.setPiecesParJour(piecesParJour);
        precisionParameter.setOtherTask((OtherTask) task);


        return taskPrecisionParameterRepository.save(precisionParameter);
    }

    public TaskTimeParameter saveTaskTimeParameter(boolean status, String name, double nombreHeure, double tempsMinParHeure,
                                                   double totalTimeEnMin, double proportionTemps, String taskId) throws TasKNotFindException {

        Task task = taskRepository.findById(taskId).orElse(null);
        if(task == null){
            throw  new TasKNotFindException("Task Not Find!");
        }
        TaskTimeParameter timeParameter = new TaskTimeParameter();
        timeParameter.setStatus(status);
        timeParameter.setName(name);
        timeParameter.setNombreHeure(nombreHeure);
        timeParameter.setTempsMinParHeure(tempsMinParHeure);
        timeParameter.setTotalTimeEnMin(totalTimeEnMin);
        timeParameter.setProportionTemps(proportionTemps);
        timeParameter.setOtherTask((OtherTask) task);

        return taskTimeParameterRepository.save(timeParameter);
    }

    public ComplexTask saveComplexTask(String name, boolean status, int numero) {

        ComplexTask complexTask = new ComplexTask();
        complexTask.setId(UUID.randomUUID().toString());
        complexTask.setTaskName(name);
        complexTask.setNumero(numero);
        complexTask.setStatus(status);

        return taskRepository.save(complexTask);
    }

    @Override
    public CategoryParametreDecolletage saveCategoryParametreDecolletage(String name, String complexTaskId) throws TasKNotFindException {

        Task task = taskRepository.findById(complexTaskId).orElse(null);
        if(task == null){
            throw  new TasKNotFindException("Task Not Find!");
        }
        CategoryParametreDecolletage decolletageCate = new CategoryParametreDecolletage();
        decolletageCate.setComplexTask((ComplexTask) task);
        decolletageCate.setName(name);

        return categoryParametreDecolletageRepository.save(decolletageCate);
    }

    @Override
    public ParametreDecolletage saveParametreDecolletage(String name, boolean status, double tempsDeMontage, double coutMoyenOutils, Long categoryId) throws CategoryParametreDecolletageNotFindException {

        CategoryParametreDecolletage categoryParametreDecolletage = categoryParametreDecolletageRepository.findById(categoryId).orElse(null);
        if (categoryParametreDecolletage == null){
            throw  new CategoryParametreDecolletageNotFindException("CategoryParametreDecolletage Not Find!");
        }
        ParametreDecolletage parametreDecolletage = new ParametreDecolletage();
        parametreDecolletage.setName(name);
        parametreDecolletage.setStatus(status);
        parametreDecolletage.setTempsDeMontage(tempsDeMontage);
        parametreDecolletage.setCoutMoyenOutils(coutMoyenOutils);
        parametreDecolletage.setCategoryParametreDecolletage(categoryParametreDecolletage);

        return parametreDecolletageRepository.save(parametreDecolletage);
    }

    public ParametreDecolletage saveParametreDecolletage(String name) {
        ParametreDecolletage parametreDecolletage = new ParametreDecolletage();
        parametreDecolletage.setName(name);
        return parametreDecolletageRepository.save(parametreDecolletage);
    }

    public OtherTask saveOtherTask(String name, boolean status, int numero, double tempsCycleDeBaseSecond,
                                   double tempsDeReglageHeur, double tempsDeCycleCalculerSecond, Long categoryId) throws TasKCategoryNotFindException {

        TaskCategory taskCategory = taskCategoryRepository.findById(categoryId).orElse(null);
        if(taskCategory == null){
            throw  new TasKCategoryNotFindException("Category Not Find!");
        }
        OtherTask otherTask = new OtherTask();
        otherTask.setTaskCategory(taskCategory);

        otherTask.setTaskName(name);
        otherTask.setId(UUID.randomUUID().toString());
        otherTask.setStatus(status);
        otherTask.setNumero(numero);
        otherTask.setTempsCycleDeBaseSecond(tempsCycleDeBaseSecond);
        otherTask.setTempsDeReglageHeur(tempsDeReglageHeur);
        otherTask.setTempsDeCycleCalculerSecond(tempsDeCycleCalculerSecond);

        return taskRepository.save(otherTask);
    }

    public List<TaskCategory> listCategory() {
        return taskCategoryRepository.findAll();
    }
    public void updateTask(String id, boolean status) {
        taskRepository.updateTaskStatus(id,status);
    }
    public TaskCategory getTaskCategoryByName(String name) {
        return taskCategoryRepository.findByCategoryName(name);
    }
    public Task findTaskWithHighestNumber() {
        return taskRepository.findTaskWithHighestNumber();
    }
    public void decrementTaskNumbers(int numero) {
        taskRepository.decrementTaskNumbers(numero);
    }

    public List<Task> findByStatusTrueOrderByNumeroAsc() {
        return taskRepository.findByStatusTrueOrderByNumeroAsc();
    }

    @Override
    public List<Task> findByTaskCategory(TaskCategory taskCategory) {
        return taskRepository.findByTaskCategory(taskCategory);
    }
    public Task maxNumero() {
        return taskRepository.findFirstByOrderByNumeroDesc();
    }

    public void updateTaskNumber(String id, Integer nouveauNumero) {
        taskRepository.updateTaskNumber(id,nouveauNumero);
    }
    public void updateTasksStatusAndNumber() {
        taskRepository.updateTasksStatusAndNumber();
    }

    public Client saveClient(Client client) {
        return null;
    }

    public DefaultParameter saveDefaultParameter(DefaultParameter defaultParameter) {
        return null;
    }
    public Piece savePiece(Piece piece) {
        return null;
    }

    public Task getTaskById(String id) {
        return taskRepository.findById(id).get();
    }

    public Synthesis saveSynthesis(Synthesis synthesis) {
        return null;
    }
}
