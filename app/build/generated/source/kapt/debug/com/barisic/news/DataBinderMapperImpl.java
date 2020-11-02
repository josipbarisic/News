package com.barisic.news;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.barisic.news.databinding.ArticleListItemBindingImpl;
import com.barisic.news.databinding.ArticleListItemBindingNightImpl;
import com.barisic.news.databinding.BottomSheetWebViewDialogBindingImpl;
import com.barisic.news.databinding.FragmentNewsBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ARTICLELISTITEM = 1;

  private static final int LAYOUT_BOTTOMSHEETWEBVIEWDIALOG = 2;

  private static final int LAYOUT_FRAGMENTNEWS = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.barisic.news.R.layout.article_list_item, LAYOUT_ARTICLELISTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.barisic.news.R.layout.bottom_sheet_web_view_dialog, LAYOUT_BOTTOMSHEETWEBVIEWDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.barisic.news.R.layout.fragment_news, LAYOUT_FRAGMENTNEWS);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ARTICLELISTITEM: {
          if ("layout-night/article_list_item_0".equals(tag)) {
            return new ArticleListItemBindingNightImpl(component, view);
          }
          if ("layout/article_list_item_0".equals(tag)) {
            return new ArticleListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for article_list_item is invalid. Received: " + tag);
        }
        case  LAYOUT_BOTTOMSHEETWEBVIEWDIALOG: {
          if ("layout/bottom_sheet_web_view_dialog_0".equals(tag)) {
            return new BottomSheetWebViewDialogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottom_sheet_web_view_dialog is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTNEWS: {
          if ("layout/fragment_news_0".equals(tag)) {
            return new FragmentNewsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_news is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(1, "Article");
      sKeys.put(2, "NewsViewModel");
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout-night/article_list_item_0", com.barisic.news.R.layout.article_list_item);
      sKeys.put("layout/article_list_item_0", com.barisic.news.R.layout.article_list_item);
      sKeys.put("layout/bottom_sheet_web_view_dialog_0", com.barisic.news.R.layout.bottom_sheet_web_view_dialog);
      sKeys.put("layout/fragment_news_0", com.barisic.news.R.layout.fragment_news);
    }
  }
}
