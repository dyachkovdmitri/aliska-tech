package com.neiron.neiron.sinonimes;

import com.neiron.neiron.entities.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TypeTree {
    public final static Integer[][] typesTree = {
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 2, 2, 2, 0},
            {1, 2, 2, 2, 1},
            {1, 2, 2, 2, 2},
            {1, 2, 3, 3, 0},
            {1, 2, 3, 4, 0},
            {1, 2, 4, 5, 0},
            {1, 2, 4, 6, 0},
            {1, 2, 5, 0, 0},
            {1, 3, 0, 0, 0},
            {1, 4, 0, 0, 0},
            {1, 5, 0, 0, 0},
    };

    public static Item getTypeTree(Item item) {

        String[] words = item.getUnparsedLine().split(" ");
            for (Integer[] aTypesTree : typesTree) {
                if (Objects.equals(aTypesTree[4], item.getType5())) {
                    item.setType4(aTypesTree[3]);
                    item.setType3(aTypesTree[2]);
                    item.setType2(aTypesTree[1]);
                    item.setType1(aTypesTree[0]);
                }
                if (Objects.equals(aTypesTree[3], item.getType5())) {
                    item.setType3(aTypesTree[2]);
                    item.setType2(aTypesTree[1]);
                    item.setType1(aTypesTree[0]);
                }
                if (Objects.equals(aTypesTree[2], item.getType5())) {
                    item.setType2(aTypesTree[1]);
                    item.setType1(aTypesTree[0]);
                }
                if (Objects.equals(aTypesTree[1], item.getType5())) {
                    item.setType1(aTypesTree[0]);
                }
            }
        return item;
    }
}


//лампа - накал -
//лампа - накал - 1галоген
//лампа - газоразряд - 2ртутные          - 1ВД
//лампа - газоразряд - 2ртутные          - 2НД - 1трубка
//лампа - газоразряд - 2ртутные              - 2НД - 2КЛЛ
//лампа - газоразряд - 3натрий             - 3ВД
//лампа - газоразряд - 3натрий            - 4НД
//лампа - газоразряд - 4металлогалоген - 5керамический
//лампа - газоразряд - 4металлогалоген - 6обычный
//лампа - газоразряд - 5ксенон
//лампа - светодиодные
//лампа - спец
//лампа - авто