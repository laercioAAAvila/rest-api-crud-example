package com.example.restapicrudexample;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CarController {

    CarRepository carRepository;

    @GetMapping("/car")
    public List<Car> getAllCar(){
        return carRepository.findAll();
    }
    @GetMapping("/car/{id}")
    public Car findById(@PathVariable Long id){
        return carRepository.findById(id).get();
    }
    @PostMapping("/car")
    public Car saveCar (@RequestBody Car car){
        return carRepository.save(car);
    }
    @GetMapping("/car/edit/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car){
        car.setId(id);
        return carRepository.save(car);
    }
    @DeleteMapping("/car/{id}")
    public void deleteCar(@PathVariable Long id){
        carRepository.deleteById(id);
    }

}
