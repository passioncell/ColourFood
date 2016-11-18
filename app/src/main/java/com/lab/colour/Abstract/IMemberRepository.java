package com.lab.colour.Abstract;

import com.lab.colour.Model.JoinModel;

/**
 * Created by SeoHyeonBae on 2016-11-18.
 */

public interface IMemberRepository {
    String join(JoinModel joinModel);
    String login(String id, String pw);
}
