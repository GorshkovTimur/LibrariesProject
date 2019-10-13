package com.timmyg.librariesproject.Model;

import com.timmyg.librariesproject.R;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<Integer> list;

    public Model() {
        this.list = new ArrayList<>();

        for (int i = 0; i < 10 ; i++) {
            list.add(R.drawable.biohazard);
        }

    }

    public List<Integer> getList() {
        return list;
    }
}
