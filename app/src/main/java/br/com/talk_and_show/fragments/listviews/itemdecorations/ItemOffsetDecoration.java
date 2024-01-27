package br.com.talk_and_show.fragments.listviews.itemdecorations;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {
    // Atributos
    private int itemOffsetTop;
    private int itemOffsetBottom;
    private int itemOffsetRight;
    private int itemOffsetLeft;
    private int spanCount;
    private int currentItemSpanIndex;
    private int currentItemAdapterPosition;

    // Métodos de acesso
    public int getItemOffsetTop() {
        return itemOffsetTop;
    }

    public void setItemOffsetTop(int itemOffsetTop) {
        this.itemOffsetTop = itemOffsetTop;
    }

    public int getItemOffsetBottom() {
        return itemOffsetBottom;
    }

    public void setItemOffsetBottom(int itemOffsetBottom) {
        this.itemOffsetBottom = itemOffsetBottom;
    }

    public int getItemOffsetRight() {
        return itemOffsetRight;
    }

    public void setItemOffsetRight(int itemOffsetRight) {
        this.itemOffsetRight = itemOffsetRight;
    }

    public int getItemOffsetLeft() {
        return itemOffsetLeft;
    }

    public void setItemOffsetLeft(int getItemOffsetLeft) {
        this.itemOffsetLeft = getItemOffsetLeft;
    }

    public ItemOffsetDecoration(int itemOffsetTop,
                                int itemOffsetBottom, int itemOffsetRight, int itemOffsetLeft) {
        this.setItemOffsetTop(itemOffsetTop);
        this.setItemOffsetBottom(itemOffsetBottom);
        this.setItemOffsetRight(itemOffsetRight);
        this.setItemOffsetLeft(itemOffsetLeft);
    }

    public ItemOffsetDecoration(int itemOffsetVertical, int itemOffsetHorizontal) {
        this.setItemOffsetTop(itemOffsetVertical);
        this.setItemOffsetBottom(itemOffsetVertical);
        this.setItemOffsetRight(itemOffsetHorizontal);
        this.setItemOffsetLeft(itemOffsetHorizontal);
    }

    public ItemOffsetDecoration(int itemOffset) {
        this.setItemOffsetTop(itemOffset);
        this.setItemOffsetBottom(itemOffset);
        this.setItemOffsetRight(itemOffset);
        this.setItemOffsetLeft(itemOffset);
    }

    @SuppressLint("SwitchIntDef")
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                               @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            this.getGridItemOffset(outRect, view, parent, state);
            return;
        }

        if (parent.getLayoutManager() instanceof LinearLayoutManager) {
            switch (((LinearLayoutManager) parent.getLayoutManager()).getOrientation()) {
                case LinearLayoutManager.HORIZONTAL: {
                    this.getHorizontalItemOffset(outRect, view, parent, state);
                    break;
                }
                case LinearLayoutManager.VERTICAL: {
                    this.getVerticalItemOffset(outRect, view, parent, state);
                }
            }
        }
    }

    private void getGridItemOffset(@NonNull Rect outRect, @NonNull View view,
                                   @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        this.spanCount = ((GridLayoutManager) parent.getLayoutManager()).getSpanCount();
        this.currentItemSpanIndex = ((GridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
        this.currentItemAdapterPosition = parent.getChildAdapterPosition(view);

        boolean isNotFirstColumn = this.currentItemSpanIndex > 0;
        if (isNotFirstColumn) {
            outRect.left = this.getItemOffsetLeft()/2;
        }

        boolean isNotLastColumn = this.currentItemSpanIndex < this.spanCount-1;
        if (isNotLastColumn) {
            outRect.right = this.getItemOffsetRight()/2;
        }

        boolean isNotFirstRow = this.currentItemAdapterPosition >= this.spanCount;
        if (isNotFirstRow) {
            outRect.top = this.getItemOffsetTop()/2;
        }

        int incompleteLastRowItemCount = state.getItemCount() % this.spanCount;
        boolean isNotLastRow = this.currentItemAdapterPosition < (state.getItemCount() - incompleteLastRowItemCount);
        if (isNotLastRow) {
            outRect.bottom = this.getItemOffsetBottom()/2;
        }
    }

    private void getHorizontalItemOffset(@NonNull Rect outRect, @NonNull View view,
                                         @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        this.spanCount = state.getItemCount();
        this.currentItemSpanIndex = parent.getChildAdapterPosition(view);
        this.currentItemAdapterPosition = currentItemSpanIndex;

        boolean isNotFirstColumn = this.currentItemSpanIndex > 0;
        if (isNotFirstColumn) {
            outRect.left = this.getItemOffsetLeft();
        }

        boolean isNotLastColumn = this.currentItemSpanIndex < this.spanCount-1;
        if (isNotLastColumn) {
            outRect.right = this.getItemOffsetRight();
        }

        outRect.top = this.getItemOffsetTop();
        outRect.bottom = this.getItemOffsetBottom();
    }

    private void getVerticalItemOffset(@NonNull Rect outRect, @NonNull View view,
                                       @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        this.spanCount = 1;
        this.currentItemSpanIndex = 1;
        this.currentItemAdapterPosition = parent.getChildAdapterPosition(view);

        outRect.left = this.getItemOffsetLeft();
        outRect.right = this.getItemOffsetRight();

        boolean isNotFirstRow = this.currentItemAdapterPosition >= this.spanCount;
        if (isNotFirstRow) {
            outRect.top = this.getItemOffsetTop();
        }

        boolean isNotLastRow = this.currentItemAdapterPosition < parent.getChildCount() - this.spanCount;
        if (isNotLastRow) {
            outRect.bottom = this.getItemOffsetBottom();
        }

    }

}
