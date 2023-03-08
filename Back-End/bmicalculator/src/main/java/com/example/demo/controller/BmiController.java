package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.BMIRepository;
import com.example.demo.model.BMI;
@RestController
@RequestMapping("/bmi")
public class BmiController {

  @Autowired
  private BMIRepository bmiRepository;
  @CrossOrigin(origins = "*")
  @PostMapping
  public ResponseEntity<BMI> calculateBMI(@RequestBody BMI request) {
	  long id  = request.getId();
    double height = request.getHeight();
    double weight = request.getWeight();
    double bmiValue = weight / Math.pow(height / 100, 2);
    BMI bmi = new BMI(id, height, weight, bmiValue);
    bmiRepository.save(bmi);
    return new ResponseEntity<>(bmi, HttpStatus.CREATED);
  }
  @CrossOrigin(origins = "*")
  @GetMapping
  public List<BMI> getAllBMIs() {
    return bmiRepository.findAll();
  }
  @CrossOrigin(origins = "*")
  @GetMapping("/{id}")
  public Optional<BMI> getById(@PathVariable long id){
	  return bmiRepository.findById(id);
  }
  @CrossOrigin(origins = "*")
  @PutMapping

public ResponseEntity<BMI> updateBMI(@RequestBody BMI request) {
BMI bmi = bmiRepository.findById(request.getId()).orElse(null);
if (bmi == null) {
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
bmi.setHeight(request.getHeight());
bmi.setWeight(request.getWeight());
bmi.setBmiValue(request.getWeight() / Math.pow(request.getHeight() / 100, 2));
bmiRepository.save(bmi);
return new ResponseEntity<>(bmi, HttpStatus.OK);
}
@CrossOrigin(origins = "*")
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteBMI(@PathVariable Long id) {
BMI bmi = bmiRepository.findById(id).orElse(null);
if (bmi == null) {
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
bmiRepository.delete(bmi);
return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

}