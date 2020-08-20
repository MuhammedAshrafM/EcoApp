package com.example.ecommerceapp.data;

import android.graphics.Canvas;
import android.view.View;

import com.example.ecommerceapp.ui.cart.AddressesSavedAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemTouchHelper extends ItemTouchHelper.SimpleCallback {

    private ItemTouchListener listener;

    public RecyclerItemTouchHelper(int dragDirs, int swipeDirs, ItemTouchListener listener) {
        super(dragDirs, swipeDirs);
        this.listener = listener;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        if(listener != null){
            listener.onSwiped(viewHolder, direction, viewHolder.getAdapterPosition());
        }
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        View foregroundView = ((AddressesSavedAdapter.AddressesSavedViewHolder)viewHolder).foregroundCola;
        getDefaultUIUtil().clearView(foregroundView);
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        if(viewHolder != null){
            View foregroundView = ((AddressesSavedAdapter.AddressesSavedViewHolder)viewHolder).foregroundCola;
            getDefaultUIUtil().onSelected(foregroundView);
        }
    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View foregroundView = ((AddressesSavedAdapter.AddressesSavedViewHolder)viewHolder).foregroundCola;
        getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View foregroundView = ((AddressesSavedAdapter.AddressesSavedViewHolder)viewHolder).foregroundCola;
        getDefaultUIUtil().onDrawOver(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);
    }
}