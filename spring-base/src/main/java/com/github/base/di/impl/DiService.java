package com.github.base.di.impl;

import com.github.base.di.Mapper;
import com.github.base.di.Service;
import org.springframework.beans.factory.BeanNameAware;

/**
 * zhangbo
 */
public class DiService implements Service{

  private Mapper mapper;

  public DiService(Mapper mapper){
      this.mapper=mapper;
  }

  public void addService(){
      mapper.add();
  }

}
