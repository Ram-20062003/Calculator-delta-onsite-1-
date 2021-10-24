package com.example.calculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LowerOperationViewModel extends ViewModel {
    private final MutableLiveData<CharSequence> numbers=new MutableLiveData<CharSequence>();
    public void selectitem(CharSequence input)
    {
        numbers.setValue(input);
    }
    public LiveData<CharSequence> getitem()
    {
        return numbers;
    }
}