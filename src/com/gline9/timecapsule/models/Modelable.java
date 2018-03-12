package com.gline9.timecapsule.models;


public interface Modelable<M extends Model<M>>
{
    public M getModel();
}
