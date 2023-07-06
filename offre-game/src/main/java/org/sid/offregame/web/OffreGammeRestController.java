package org.sid.offregame.web;

import lombok.AllArgsConstructor;
import org.sid.offregame.dao.*;
import org.sid.offregame.dto.OtherTaskDTO;
import org.sid.offregame.entities.*;
import org.sid.offregame.mappers.OffreGammeMapperImpl;
import org.sid.offregame.services.OffreGameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.sid.offregame.dto.*;


import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;


@Controller
@AllArgsConstructor
public class OffreGammeRestController {


    private TaskCategoryRepository taskCategoryRepository;
    private OffreGameService offreGameService;
    private TaskRepository taskRepository;
    private OffreGammeMapperImpl dto;
    private TaskPrecisionParameterRepository taskPrecisionParameterRepository;
    private TaskTimeParameterRepository taskTimeParameterRepository;
    private SubOtherTaskRepository subOtherTaskRepository;
    private CategoryParametreDecolletageRepository cateParamDecolletageRepository;
    private ParametreDecolletageRepository parametreDecolletageRepository;


    @PostMapping("/othertask/update")
    public String updateSubTasks(@ModelAttribute("otherTaskDTO") OtherTaskDTO otherTaskDTO) {

        OtherTask otherTask = (OtherTask) offreGameService.getTaskById(otherTaskDTO.getId());
        otherTask.setEdit(true);
        otherTask.setTempsDeReglageEnHeure(otherTask.getTempsDeReglageHeur());
        int count = 0;
        for (SubOtherTask subOtherTask: otherTask.getSubOtherTasks()){
            count = count + 1;
            subOtherTask.setNumeroSequence(otherTask.getNumero() + count);
            subOtherTaskRepository.save(subOtherTask);
        }
        BigDecimal roundedNumber = BigDecimal.valueOf((otherTaskDTO.getTaskPrecisionParametersDTO().get(0).getPourMilParPcsEnHeure()/1000)).setScale(4, RoundingMode.HALF_UP);
        double roundedValue = roundedNumber.doubleValue();
        otherTask.setTempsDeProduction(roundedValue);
        taskRepository.save(otherTask);
        return "redirect:/";
    }

    @PostMapping("/complextask/update")
    public String updateDecolletage(@ModelAttribute("ComplexTaskDTO") ComplexTaskDTO complexTaskDTO) {

        Task task = (ComplexTask) offreGameService.getTaskById(complexTaskDTO.getId());
        task.setEdit(true);
        if(complexTaskDTO.isPoolA()){
            task.setTaskName(task.getTaskName() + " POOL A");
        }else if (complexTaskDTO.isPoolB()){
            task.setTaskName(task.getTaskName() + " POOL B");
        }else if (complexTaskDTO.isPoolC()){
            task.setTaskName(task.getTaskName() + " POOL C");
        }else if (complexTaskDTO.isPoolD()){
            task.setTaskName(task.getTaskName() + " POOL D");
        }else if (complexTaskDTO.isPoolE()){
            task.setTaskName(task.getTaskName() + " POOL E");
        }else if (complexTaskDTO.isPoolF()){
            task.setTaskName(task.getTaskName() + " POOL F");
        }else if (complexTaskDTO.isPoolH()){
            task.setTaskName(task.getTaskName() + " POOL H");
        }

        int count = 0;
        for (SubOtherTask subOtherTask: task.getSubOtherTasks()){
            count = count + 1;
            subOtherTask.setNumeroSequence(task.getNumero() + count);
            subOtherTaskRepository.save(subOtherTask);
        }

        BigDecimal roundedNumber = BigDecimal.valueOf((((1000 * complexTaskDTO.getTempsDeCycleDeBase()) / 3600) / 1000)).setScale(4, RoundingMode.HALF_UP);
        double roundedValue = roundedNumber.doubleValue();
        task.setTempsDeProduction(roundedValue);
        task.setTempsDeReglageEnHeure(complexTaskDTO.getTempsDeReglageEnHeure());
        taskRepository.save(task);

        return "redirect:/";
    }

    @GetMapping("/findTask")
    @ResponseBody
    public TaskDTO findTask(@RequestParam("id") String id,Model model) {

        Task task = taskRepository.findById(id).get();

        List<SubOtherTaskDTO> subOtherTaskDTOS = new ArrayList<>();
        for (SubOtherTask subOtherTask: subOtherTaskRepository.findByTaskId(task.getId())) {
            subOtherTaskDTOS.add(dto.toSubOtherTaskDTO(subOtherTask));
        }

        if(task instanceof OtherTask){

            OtherTask otherTask = (OtherTask) task;
            OtherTaskDTO otherTaskDTO = new OtherTaskDTO();

            otherTaskDTO.setTaskName(task.getTaskName());
            otherTaskDTO.setStatus(task.isStatus());
            otherTaskDTO.setNumero(task.getNumero());
            otherTaskDTO.setTempsInterOperatoireEnHeure(task.getTempsInterOperatoireEnHeure());
            otherTaskDTO.setId(task.getId());
            otherTaskDTO.setEdit(task.isEdit());
            otherTaskDTO.setTempsDeReglageHeur(otherTask.getTempsDeReglageHeur());
            otherTaskDTO.setTempsCycleDeBaseSecond(otherTask.getTempsCycleDeBaseSecond());
            otherTaskDTO.setTempsDeCycleCalculerSecond(otherTask.getTempsDeCycleCalculerSecond());
            otherTaskDTO.setProportionTotalTemps(otherTask.getProportionTotalTemps());
            otherTaskDTO.setDecolletage(otherTask.isDecolletage());

            List<TaskPrecisionParameterDTO> taskPrecisionParameterDTOS = new ArrayList<>();
            List<TaskTimeParameterDTO> taskTimeParameterDTOS = new ArrayList<>();

            for (TaskPrecisionParameter precision: taskPrecisionParameterRepository.findByOtherTaskId(otherTask.getId())) {
                taskPrecisionParameterDTOS.add(dto.toTaskPrecisionParameterDTO(precision));
            }

            for (TaskTimeParameter timeParameter: taskTimeParameterRepository.findByOtherTaskId(otherTask.getId())) {
                taskTimeParameterDTOS.add(dto.toTaskTimeParameterDTO(timeParameter));
            }

            otherTaskDTO.setTaskPrecisionParametersDTO(taskPrecisionParameterDTOS);
            otherTaskDTO.setTaskTimeParametersDTO(taskTimeParameterDTOS);
            otherTaskDTO.setSubOtherTaskDTOS(subOtherTaskDTOS);

            return otherTaskDTO;

        }else{

            ComplexTask complexTask = (ComplexTask) task;

            ComplexTaskDTO complexTaskDTO = dto.toComplexTaskDTO(complexTask);
            complexTaskDTO.setId(complexTask.getId());

            complexTaskDTO.setSubOtherTaskDTOS(subOtherTaskDTOS);
            List<CategoryParametreDecolletageDTO> cateParamDecolletageDTOArrayList = new ArrayList<>();

            for (CategoryParametreDecolletage catDecol: cateParamDecolletageRepository.findByComplexTaskId(complexTask.getId())) {
                cateParamDecolletageDTOArrayList.add(dto.toCategoryParametreDecolletageDTO(catDecol));
            }

            for (CategoryParametreDecolletageDTO catDTO: cateParamDecolletageDTOArrayList) {
                List<ParametreDecolletageDTO> parametreDecolletagesDTO = new ArrayList<>();
                for (ParametreDecolletage param: parametreDecolletageRepository.findByCategoryParametreDecolletageId(catDTO.getId())) {
                    parametreDecolletagesDTO.add(dto.toParametreDecolletageDTO(param));
                }
                catDTO.setParametreDecolletagesDTO(parametreDecolletagesDTO);
            }
            complexTaskDTO.setCategoryParametreDecolletagesDTO(cateParamDecolletageDTOArrayList);

            return complexTaskDTO;
        }
    }

    @PostMapping("/updateTasksStatusAndNumber")
    public String updateTasksStatusAndNumber() {
        offreGameService.updateTasksStatusAndNumber();
        return "redirect:/";
    }


    @GetMapping("/categories")
    public String getCategoryTest(Model model, @RequestParam(name = "page",defaultValue = "0") int page,
                                  @RequestParam(name = "size",defaultValue = "5") int size) {

        Page<TaskCategory> taskCategoryPage = taskCategoryRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("pagecat",new int[taskCategoryPage.getTotalPages()]);

        model.addAttribute("categories", taskCategoryRepository.findAll());
        return "index";
    }

    @GetMapping("/")
    public String getCategory(Model model) {

        List<TaskCategory> categories = taskCategoryRepository.findAll();
        List<List<Task>> listeDeListes = new ArrayList<>();

        for (TaskCategory cate: categories) {
            listeDeListes.add(cate.getTasks());
        }

        List<Task> taskChoice = offreGameService.findByStatusTrueOrderByNumeroAsc();
        List<Task> listTaskEdit = new ArrayList<>();

        for (Task task: taskChoice){
            if(task.isEdit()){
                listTaskEdit.add(task);
            }
        }

        List<Task> taskList = listeDesTachesEtSousTche(listTaskEdit);
        model.addAttribute("categories", categories);
        model.addAttribute("otherTaskListCheck", taskChoice);
        model.addAttribute("taskWithSubTasks", taskList);
        model.addAttribute("allTask", ajusterLongueurListes(obtenirElements(listeDeListes)) );

        List<List<TaskCategory>> groupes = diviserEnGroupes(categories);
        List<TaskCategory> categories1= groupes.get(0);
        List<TaskCategory> categories2 = groupes.get(1);
        List<TaskCategory> categories3 = groupes.get(2);

        List<List<Task>> listeDeListes1 = new ArrayList<>();
        List<List<Task>> listeDeListes2 = new ArrayList<>();
        List<List<Task>> listeDeListes3 = new ArrayList<>();

        for (TaskCategory cate: categories1) {
            listeDeListes1.add(cate.getTasks());
        }
        for (TaskCategory cate: categories2) {
            listeDeListes2.add(cate.getTasks());
        }
        for (TaskCategory cate: categories3) {
            listeDeListes3.add(cate.getTasks());
        }

        model.addAttribute("categories1", categories1);
        model.addAttribute("categories2", categories2);
        model.addAttribute("categories3", categories3);

        model.addAttribute("TaskFirst", ajusterLongueurListes(obtenirElements(listeDeListes1)));
        model.addAttribute("TaskSecond", ajusterLongueurListes(obtenirElements(listeDeListes2)));
        model.addAttribute("TaskThird", ajusterLongueurListes(obtenirElements(listeDeListes3)));

        return "index";
    }

    @PostMapping("/")
    public String getCategorypost(Model model) {

        List<TaskCategory> categories = taskCategoryRepository.findAll();

        List<List<Task>> listeDeListes = new ArrayList<>();

        for (TaskCategory cate: categories) {
            listeDeListes.add(cate.getTasks());
        }

        List<Task> taskChoice = offreGameService.findByStatusTrueOrderByNumeroAsc();
        List<Task> listTaskEdit = new ArrayList<>();

        for (Task task: taskChoice){
            if(task.isEdit()){
                listTaskEdit.add(task);
            }
        }

        List<Task> taskList = listeDesTachesEtSousTche(listTaskEdit);
        model.addAttribute("categories", categories);
        model.addAttribute("otherTaskListCheck", taskChoice);
        model.addAttribute("taskWithSubTasks", taskList);
        model.addAttribute("allTask", ajusterLongueurListes(obtenirElements(listeDeListes)) );

        List<List<TaskCategory>> groupes = diviserEnGroupes(categories);
        List<TaskCategory> categories1= groupes.get(0);
        List<TaskCategory> categories2 = groupes.get(1);
        List<TaskCategory> categories3 = groupes.get(2);

        List<List<Task>> listeDeListes1 = new ArrayList<>();
        List<List<Task>> listeDeListes2 = new ArrayList<>();
        List<List<Task>> listeDeListes3 = new ArrayList<>();

        for (TaskCategory cate: categories1) {
            listeDeListes1.add(cate.getTasks());
        }
        for (TaskCategory cate: categories2) {
            listeDeListes2.add(cate.getTasks());
        }
        for (TaskCategory cate: categories3) {
            listeDeListes3.add(cate.getTasks());
        }

        model.addAttribute("categories1", categories1);
        model.addAttribute("categories2", categories2);
        model.addAttribute("categories3", categories3);

        model.addAttribute("TaskFirst", ajusterLongueurListes(obtenirElements(listeDeListes1)) );
        model.addAttribute("TaskSecond", ajusterLongueurListes(obtenirElements(listeDeListes2)) );
        model.addAttribute("TaskThird", ajusterLongueurListes(obtenirElements(listeDeListes3)) );


        return "index";
    }

    @PostMapping("/toggle")
    public String changeTaskStatus(@RequestParam("itemId") String itemId,
                            @RequestParam("isChecked") boolean isChecked, Model model) {

        offreGameService.updateTask(itemId,isChecked);
        Task task = offreGameService.maxNumero();
        Task task1 = taskRepository.findById(itemId).get();
        int nb = task1.getNumero();

        if(!isChecked && task.getNumero() != 0 ){
            offreGameService.decrementTaskNumbers(nb);
            offreGameService.updateTaskNumber(itemId,0);
        }else if(task.getNumero() == 0 && isChecked){
            offreGameService.updateTaskNumber(itemId,10);
        }else if (task.getNumero() != 0 && isChecked){
            offreGameService.updateTaskNumber(itemId,task.getNumero()+10);
        }

        if(!isChecked){
            task1.setEdit(false);
            task1.setTempsDeProduction(0);
            if(task1 instanceof ComplexTask){
                task1.setTaskName("Decolletage");
            }
            taskRepository.save(task1);
        }
        return "redirect:/";
    }

    @GetMapping ("/oncheck")
    public String onSelectTask(@RequestParam("id") String id) {
        Task task = taskRepository.findById(id).get();
        task.setEdit(false);
        task.setTempsDeProduction(0);
        if(task instanceof ComplexTask){
            task.setTaskName("Decolletage");
        }
        taskRepository.save(task);

        int nb = taskRepository.findById(id).get().getNumero();
        offreGameService.updateTask(id,false);
        offreGameService.updateTaskNumber(id,0);
        offreGameService.decrementTaskNumbers(nb);
        return "redirect:/";
    }



    public static List<List<Task>> obtenirElements(List<List<Task>> listeDeListes) {
        int maxSize = 0;

        // Trouver la taille maximale parmi les listes de tâches
        for (List<Task> liste : listeDeListes) {
            if (liste.size() > maxSize) {
                maxSize = liste.size();
            }
        }

        List<List<Task>> resultat = new ArrayList<>();

        // Construire les listes résultantes
        for (int i = 0; i < maxSize; i++) {
            List<Task> nouvelleListe = new ArrayList<>();

            for (List<Task> liste : listeDeListes) {
                if (i < liste.size()) {
                    nouvelleListe.add(liste.get(i));
                }
            }

            resultat.add(nouvelleListe);
        }

        return resultat;
    }

    public static List<List<Task>> obtenirMatriceCarree(List<List<Task>> listeDeListes) {
        int maxSize = 0;

        // Trouver la taille maximale parmi les listes de tâches
        for (List<Task> liste : listeDeListes) {
            if (liste.size() > maxSize) {
                maxSize = liste.size();
            }
        }

        List<List<Task>> resultat = new ArrayList<>();

        // Construire la matrice carrée en complétant les autres éléments par null
        for (List<Task> liste : listeDeListes) {
            List<Task> nouvelleListe = new ArrayList<>(liste);

            // Compléter avec des null si nécessaire
            while (nouvelleListe.size() < maxSize) {
                nouvelleListe.add(null);
            }

            resultat.add(nouvelleListe);
        }

        // Compléter avec des listes de null si nécessaire
        while (resultat.size() < maxSize) {
            List<Task> listeNulle = new ArrayList<>();
            for (int i = 0; i < maxSize; i++) {
                listeNulle.add(null);
            }
            resultat.add(listeNulle);
        }

        return resultat;
    }


    public static List<List<Task>> ajusterLongueurListes(List<List<Task>> listes) {
        int longueurMax = 0;

        // Trouver la longueur maximale parmi toutes les listes
        for (List<Task> lst : listes) {
            if (lst.size() > longueurMax) {
                longueurMax = lst.size();
            }
        }

        List<List<Task>> nouvellesListes = new ArrayList<>();
        for (List<Task> lst : listes) {
            List<Task> nouvelleLst = new ArrayList<>(lst);

            // Ajouter des éléments null pour atteindre la longueur maximale
            while (nouvelleLst.size() < longueurMax) {
                nouvelleLst.add(null);
            }

            nouvellesListes.add(nouvelleLst);
        }

        return nouvellesListes;
    }

    public static List<List<TaskCategory>> diviserEnGroupes(List<TaskCategory> categories) {
        List<List<TaskCategory>> groupes = new ArrayList<>();

        int tailleGroupe = 7;
        int indexDebut = 0;
        int indexFin = tailleGroupe;

        while (indexDebut < categories.size()) {
            if (indexFin > categories.size()) {
                indexFin = categories.size();
            }

            List<TaskCategory> groupe = categories.subList(indexDebut, indexFin);
            groupes.add(groupe);

            indexDebut += tailleGroupe;
            indexFin += tailleGroupe;
        }

        return groupes;
    }


    public static List<Task> listeDesTachesEtSousTche(List<Task> myList){

        List<Task> tasks = new ArrayList<>();

        for (Task task: myList){
            tasks.add(task);
            for (SubOtherTask subOtherTask: task.getSubOtherTasks()){
            OtherTask otherTask = new OtherTask();
            otherTask.setTaskName(subOtherTask.getName());
            otherTask.setStatus(subOtherTask.isStatus());
            otherTask.setNumero(subOtherTask.getNumeroSequence());
            otherTask.setTempsDeReglageEnHeure(subOtherTask.getTempsDeReglage());
            otherTask.setTempsInterOperatoireEnHeure(subOtherTask.getTempsDeProduction());
            otherTask.setEdit(true);
            otherTask.setTempsInterOperatoireEnHeure(subOtherTask.getTempsInterOperatoireEnHeure());
            otherTask.setTauxHoraireReglage(subOtherTask.getTauxHoraireReglage());
            otherTask.setTauxHoraireProduction(subOtherTask.getTauxHoraireProduction());
            otherTask.setTempsDeProduction(0);
            otherTask.setIndirect(subOtherTask.getIndirect());
            otherTask.setMarge(subOtherTask.getMarge());
            otherTask.setCalculPrEnCHF(subOtherTask.getCalculPrEnCHF());
            otherTask.setTempsDeProduction(subOtherTask.getTempsDePassageEnJour());
            otherTask.setCalculPVenCHF(subOtherTask.getCalculPVenCHF());
            tasks.add(otherTask);
            }
        }

        return  tasks;
    }


}
