package com.barisic.news.databinding;
import com.barisic.news.R;
import com.barisic.news.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentNewsBindingImpl extends FragmentNewsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.EditText mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of NewsViewModel.query.getValue()
            //         is NewsViewModel.query.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView1);
            // localize variables for thread safety
            // NewsViewModel != null
            boolean newsViewModelJavaLangObjectNull = false;
            // NewsViewModel.query
            androidx.lifecycle.MutableLiveData<java.lang.String> newsViewModelQuery = null;
            // NewsViewModel.query != null
            boolean newsViewModelQueryJavaLangObjectNull = false;
            // NewsViewModel.query.getValue()
            java.lang.String newsViewModelQueryGetValue = null;
            // NewsViewModel
            com.barisic.news.viewmodel.NewsViewModel newsViewModel = mNewsViewModel;



            newsViewModelJavaLangObjectNull = (newsViewModel) != (null);
            if (newsViewModelJavaLangObjectNull) {


                newsViewModelQuery = newsViewModel.getQuery();

                newsViewModelQueryJavaLangObjectNull = (newsViewModelQuery) != (null);
                if (newsViewModelQueryJavaLangObjectNull) {




                    newsViewModelQuery.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentNewsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }
    private FragmentNewsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.EditText) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.NewsViewModel == variableId) {
            setNewsViewModel((com.barisic.news.viewmodel.NewsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setNewsViewModel(@Nullable com.barisic.news.viewmodel.NewsViewModel NewsViewModel) {
        this.mNewsViewModel = NewsViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.NewsViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeNewsViewModelQuery((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeNewsViewModelQuery(androidx.lifecycle.MutableLiveData<java.lang.String> NewsViewModelQuery, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        androidx.lifecycle.MutableLiveData<java.lang.String> newsViewModelQuery = null;
        java.lang.String newsViewModelQueryGetValue = null;
        com.barisic.news.viewmodel.NewsViewModel newsViewModel = mNewsViewModel;

        if ((dirtyFlags & 0x7L) != 0) {



                if (newsViewModel != null) {
                    // read NewsViewModel.query
                    newsViewModelQuery = newsViewModel.getQuery();
                }
                updateLiveDataRegistration(0, newsViewModelQuery);


                if (newsViewModelQuery != null) {
                    // read NewsViewModel.query.getValue()
                    newsViewModelQueryGetValue = newsViewModelQuery.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, newsViewModelQueryGetValue);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView1androidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): NewsViewModel.query
        flag 1 (0x2L): NewsViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}