package com.createsend.models.subscribers;

public class HistoryItem {
    public String ID;
    public String Type; // TODO: Probably want to move this to an enum
    public String Name;
    public Action[] Actions;
}
