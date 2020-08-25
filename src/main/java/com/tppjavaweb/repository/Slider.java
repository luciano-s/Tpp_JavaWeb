package com.tppjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tppjavaweb.model.SliderItem;


public interface Slider extends JpaRepository<SliderItem, Long>{
}
