package com.hrayfiproject.hrayfi.controllers;

import com.hrayfiproject.hrayfi.entities.Hrayfi;
import com.hrayfiproject.hrayfi.repositories.HrayfiRepository;
import com.hrayfiproject.hrayfi.services.HrayfiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class HrayfiController {
    @Autowired
    HrayfiService hrayfiService;
    @Autowired
    HrayfiRepository hrayfiRepository;
    //pour lancer le jsp
    @RequestMapping("/createHrayfi")
    public String createHrayfi (){

        return "CreateHrayfi";
    }
  @RequestMapping("/saveHrayfi")

 public String saveHrayfi(@Valid Hrayfi hrayfi, BindingResult bindingResult)  {
        if(bindingResult.hasErrors()) return "CreateHrayfi";
      Hrayfi hrayfiController = hrayfiService.saveHrayfi(hrayfi);
 return "CreateHrayfi";
 }
@RequestMapping("/HrayfisList")
    public String HrayfisList(ModelMap modelMap,
                               @RequestParam(name = "page",defaultValue = "0") int page,
                               @RequestParam(name = "size",defaultValue = "2") int size
                               ){
       Page<Hrayfi> HrayfisController = hrayfiService.getAllHrayfiByPage(page, size);
       modelMap.addAttribute("HrayfisJsp", HrayfisController);
       modelMap.addAttribute("pages", new int[HrayfisController.getTotalPages()]);
       modelMap.addAttribute("currentPage", page);
       return "HrayfisList";
}
@RequestMapping("/deleteHrayfi")
    public String deleteHrayfi(@RequestParam("id") Long id,ModelMap modelMap, @RequestParam(name = "page",defaultValue = "0") int page,
                                @RequestParam(name = "size",defaultValue = "2") int size){
        hrayfiService.deleteHrayfiById(id);
    Page<Hrayfi> HrayfisController = hrayfiService.getAllHrayfiByPage(page, size);
    modelMap.addAttribute("HrayfisJsp", HrayfisController);
    modelMap.addAttribute("pages", new int[HrayfisController.getTotalPages()]);
    modelMap.addAttribute("currentPage", page);
    return "HrayfisList";
}
@RequestMapping("/showHrayfi")
    public String showHrayfi(@RequestParam("id") Long id,ModelMap modelMap){
        Hrayfi hrayfiController = hrayfiService.getHrayfi(id);
        modelMap.addAttribute("HrayfiJsp", hrayfiController);
        return "EditHrayfi";
}


    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/updateHrayfi")
    public String updateHrayfi(@ModelAttribute("hrayfi") Hrayfi hrayfi){
   hrayfiService.saveHrayfi(hrayfi);
        return "CreateHrayfi";
    }

    @RequestMapping("/")
    public String home(ModelMap modelMap,
                               @RequestParam(name = "page",defaultValue = "0") int page,
                               @RequestParam(name = "size",defaultValue = "2") int size
    ){
        Page<Hrayfi> HrayfisController = hrayfiService.getAllHrayfiByPage(page, size);
        modelMap.addAttribute("HrayfisJsp", HrayfisController);
        modelMap.addAttribute("pages", new int[HrayfisController.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "HrayfisList";
    }

    //public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    //@GetMapping("/uploadimage") public String displayUploadForm() {return "imageupload/index";}

   /* @PostMapping("/upload") public String uploadImage(Model model, @RequestParam("image") MultipartFile file) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + fileNames.toString());
        return "imageupload/index";
    }*/





    }


