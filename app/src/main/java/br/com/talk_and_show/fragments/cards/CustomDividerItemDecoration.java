package com.example.myapplication.fragments.cards;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



/**
 * Consiste em um DividerItemDecoration o qual permite que você escolha se haverá um divider
 * após o último item e se deseja que as alturas(vertical) ou comprimentos(horizontal) dos diveders
 * sejam de algum tamanho específico. Também permite passar drawers personalizados caso não queira
 * um divider simples
 * @noinspection unused
 */
public class CustomDividerItemDecoration extends DividerItemDecoration {

    private boolean drawDividerAfterLastItem;
    private boolean dividerSizeEqualsParentPadding;
    private int orientation;

    public boolean isDrawDividerAfterLastItem() {
        return drawDividerAfterLastItem;
    }

    public void setDrawDividerAfterLastItem(boolean drawDividerAfterLastItem) {
        this.drawDividerAfterLastItem = drawDividerAfterLastItem;
    }

    public boolean isDividerSizeEqualsParentPadding() {
        return dividerSizeEqualsParentPadding;
    }

    public void setDividerSizeEqualsParentPadding(boolean dividerSizeEqualsParentPadding) {
        this.dividerSizeEqualsParentPadding = dividerSizeEqualsParentPadding;
    }

    public int getOrientation() {
        return orientation;
    }

    @Override
    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public CustomDividerItemDecoration(Context context, int orientation, Drawable divider,
                                       boolean drawDividerAfterLastItem, boolean dividerSizeEqualsParentPadding) {
        super(context, orientation);
        this.setDrawable(divider);
        this.setDividerSizeEqualsParentPadding(dividerSizeEqualsParentPadding);
        this.setDrawDividerAfterLastItem(drawDividerAfterLastItem);
        this.setOrientation(orientation);
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() == null || this.getDrawable() == null) {
            return;
        }
        if (this.getOrientation() == VERTICAL) {
            this.drawVertical(canvas, parent);
        } else {
            this.drawHorizontal(canvas, parent);
        }
    }

    protected void drawVertical(Canvas canvas, RecyclerView parent) {
        canvas.save();
        final int left;
        final int right;

        if (parent.getClipToPadding()) {
            left = parent.getPaddingLeft();
            right = parent.getWidth() - parent.getPaddingRight();
            canvas.clipRect(left, parent.getPaddingTop(), right,
                    parent.getHeight() - parent.getPaddingBottom());
        } else {
            left = 0;
            right = parent.getWidth();
        }

        int childCount = parent.getChildCount();
        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            int leftItems = childCount % ((GridLayoutManager) parent.getLayoutManager()).getSpanCount();
            if (leftItems == 0) {childCount -= ((GridLayoutManager) parent.getLayoutManager()).getSpanCount();}
            else {childCount -= leftItems;}
        }

        for (int i = 0; i < childCount - 1; i++) {
            final View child = parent.getChildAt(i);
            Rect mBounds = new Rect();
            parent.getDecoratedBoundsWithMargins(child, mBounds);
            final int bottom = mBounds.bottom + Math.round(child.getTranslationY());
            final int top = bottom - this.getDrawable().getIntrinsicHeight();
            this.getDrawable().setBounds(left, top, right, bottom);
            this.getDrawable().draw(canvas);
        }
        canvas.restore();
    }

    protected void drawHorizontal(Canvas canvas, RecyclerView parent) {
        canvas.save();
        final int top;
        final int bottom;
        //noinspection AndroidLintNewApi - NewApi lint fails to handle overrides.
        if (parent.getClipToPadding()) {
            top = parent.getPaddingTop();
            bottom = parent.getHeight() - parent.getPaddingBottom();
            canvas.clipRect(parent.getPaddingLeft(), top,
                    parent.getWidth() - parent.getPaddingRight(), bottom);
        } else {
            top = 0;
            bottom = parent.getHeight();
        }

        int childCount = parent.getChildCount();
        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            //childCount = ((GridLayoutManager) parent.getLayoutManager()).getSpanCount();
        }


        for (int i = 0; i < childCount - 1; i++) {
            final View child = parent.getChildAt(i);
            Rect mBounds = new Rect();
            parent.getLayoutManager().getDecoratedBoundsWithMargins(child, mBounds);
            final int right = mBounds.right + Math.round(child.getTranslationX());
            final int left = right - this.getDrawable().getIntrinsicWidth();
            this.getDrawable().setBounds(left, top, right, bottom);
            this.getDrawable().draw(canvas);
        }
        canvas.restore();
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int number = state.getItemCount();
        if (this.getDrawable() == null || parent.getChildAdapterPosition(view) == state.getItemCount() - 1
        || state.getItemCount() % 2 != 0) {
            outRect.set(0, 0, 0, 0);
            return;
        }
        if (this.getOrientation() == VERTICAL) {
            outRect.set(0, 0, 0, this.getDrawable().getIntrinsicHeight());
        } else {
            outRect.set(0, 0, this.getDrawable().getIntrinsicWidth(), 0);
        }
    }
}
