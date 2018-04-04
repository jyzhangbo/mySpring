package com.github.root.service;

import com.github.root.model.User;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * zhangbo
 */
@Component
public class UserService {

    public List<User> list(Integer count) {
        List<User> users = new ArrayList<>();
        BufferedReader br = null;
        InputStreamReader reader=null;
        try {
            File file = new File("D:\\ennwifiworkspace\\mySpring\\spring-mvc\\src\\main\\webapp\\user.txt");
            reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
            br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine())!=null) {
                String[] args = line.split(",");
                User user = new User();
                user.setId(Integer.valueOf(args[0]));
                user.setName(args[1]);
                user.setAddress(args[2]);
                user.setAge(Integer.valueOf(args[3]));
                users.add(user);
            }

            return users.subList(0,count > users.size() ? users.size() : count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if(reader!=null){
                    reader.close();
                }
                if (br != null) {
                    br.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public User getById(Integer id) {
        List<User> list = list(Integer.MAX_VALUE);
        List<User> collect = list.stream().filter(user -> user.getId().equals(id)).collect(Collectors.toList());
        return collect.get(0);
    }

    public User save(User user) {
        BufferedWriter writer=null;

        try {
            File file = new File("D:\\ennwifiworkspace\\mySpring\\spring-mvc\\src\\main\\webapp\\user.txt");
            Integer id =0;
            if (!file.exists()) {
                file.createNewFile();
            }else {
                List<User> list = list(Integer.MAX_VALUE);
                id=list.get(list.size() - 1).getId();
            }
            user.setId(id+1);
            writer=new BufferedWriter(new FileWriter(file,true));
            writer.append(String.valueOf(id+1)).append(",").append(user.getName()).append(",").append(user.getAddress()).append(",").append(user.getAge().toString());
            writer.append("\r\n");
            writer.flush();
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
