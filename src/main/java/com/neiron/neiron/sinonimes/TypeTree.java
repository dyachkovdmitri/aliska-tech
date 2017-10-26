package com.neiron.neiron.sinonimes;

import com.neiron.neiron.entities.Item;

import java.util.Objects;

public class TypeTree {
    private final static Integer[][] typesTree = {
            {1, 1, 0, 0, 0},//1лампа - 1накал
            {1, 1, 1, 0, 0},//1лампа - 1накал - 1галог
            {1, 2, 2, 2, 0},//1лампа - 2газор - 2ртутн - 1ртуВД
            {1, 2, 2, 2, 1},//1лампа - 2газор - 2ртутн - 2ртуНД - 1трубк
            {1, 2, 2, 2, 2},//1лампа - 2газор - 2ртутн - 2ртуНД - 2КЛЛ
            {1, 2, 3, 3, 0},//1лампа - 2газор - 3натри - 3натВД
            {1, 2, 3, 4, 0},//1лампа - 2газор - 3натри - 4натНД
            {1, 2, 4, 5, 0},//1лампа - 2газор - 4метал - 5керам
            {1, 2, 4, 6, 0},//1лампа - 2газор - 4метал - 6обычн
            {1, 2, 5, 0, 0},//1лампа - 2газор - 5ксен0
            {1, 3, 0, 0, 0},//1лампа - 3диодн
            {1, 4, 0, 0, 0},//1лампа - 4спец
            {1, 5, 0, 0, 0},//1лампа - 5авто
    };


    public static Item getTypeTree(Item item) {
        try {
            for (Integer[] aTypesTree : typesTree) {
                if (Objects.equals(aTypesTree[4], item.getType5())) {
                    item.setType4(aTypesTree[3]);
                    item.setType3(aTypesTree[2]);
                    item.setType2(aTypesTree[1]);
                    item.setType1(aTypesTree[0]);
                }
                if (Objects.equals(aTypesTree[3], item.getType4())) {
                    item.setType3(aTypesTree[2]);
                    item.setType2(aTypesTree[1]);
                    item.setType1(aTypesTree[0]);
                }
                if (Objects.equals(aTypesTree[2], item.getType3())) {
                    item.setType2(aTypesTree[1]);
                    item.setType1(aTypesTree[0]);
                }
                if (Objects.equals(aTypesTree[1], item.getType2())) {
                    item.setType1(aTypesTree[0]);
                }
            }
        } catch (Exception e) {
            item.setType1(-1);
        }
        return item;
    }
}


