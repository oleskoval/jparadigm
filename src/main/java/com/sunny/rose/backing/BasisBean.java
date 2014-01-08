package com.sunny.rose.backing;

import org.primefaces.component.tabview.Tab;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.map.*;

import javax.faces.event.ActionEvent;
import java.io.Serializable;

/**
 * 12.02.12  12:02
 */

public class BasisBean implements Serializable
{
    boolean chartEngineChosen = true;
    boolean contactManagementChosen = false;
    boolean shopWorkflowChosen = false;
    private boolean parkingChosen = false;

    boolean contactsShown = true;
    boolean mapShown = false;

    private MapModel model = new DefaultMapModel();


    public BasisBean()
    {
        Marker marker = new Marker(new LatLng(46.484572, 30.725005), "Our Office");
        model.addOverlay(marker);
//        Circle circle = new Circle(new LatLng(46.484572, 30.725005), 3);
//        circle.setStrokeColor("Red");
//        circle.setStrokeWeight(4);
//        circle.setFillColor("Yellow");
//        circle.setFillOpacity(0.2);
//        circle.setStrokeOpacity(1);
//
//        model.addOverlay(circle);
    }

    public MapModel getModel()
    {
        return model;
    }

    public void updateTabs(ActionEvent actionEvent)
    {
        System.out.println("!!!!!!!!!!!! updateTabs");
    }

    public void showContacts(ActionEvent event)
    {
        contactsShown = true;
        mapShown = false;
    }

    public void showMap(ActionEvent event)
    {
        contactsShown = false;
        mapShown = true;
    }


    public void openChartEngine(ActionEvent event)
    {
        System.out.println("!!!openChartEngine");
        resetAllProjects();
        chartEngineChosen = true;
    }

    public void openContactManagement(ActionEvent event)
    {
        resetAllProjects();
        contactManagementChosen = true;
    }

    public void openShop(ActionEvent event)
    {
        resetAllProjects();
        shopWorkflowChosen = true;
    }

    public void openParking(ActionEvent event)
    {
        resetAllProjects();
        parkingChosen = true;
    }

    private void resetAllProjects()
    {
        chartEngineChosen = false;
        contactManagementChosen = false;
        shopWorkflowChosen = false;
        parkingChosen = false;
    }

    private int count;

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public void increment()
    {
        count++;
    }



    public void  onChange(TabChangeEvent event)
    {
        Tab activeTab = event.getTab();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!activeTab " + activeTab.getId());


    }


//     public void  chooseHome(ActionEvent actionEvent)
//     {
//         System.out.println("!!!!!!!!!!!!!! chooseHome");
//         resetAllViews();
//         homeChosen = true;
//     }
//
//    public void chooseTabView(ActionEvent actionEvent)
//    {
//        System.out.println("!!!!!!!!!!!!!!!!!!!! chooseTabView");
//        resetAllViews();
//        tabViewChosen = true;
//
//    }
//
//    private void resetAllViews()
//    {
//        homeChosen = false;
//        tabViewChosen = false;
//    }
//
//    public boolean isHomeChosen()
//    {
//        System.out.println("!!!!!!!!!!!! homeChosen "  + homeChosen);
//       return homeChosen;
//    }
//
//    public boolean isTabViewChosen()
//    {
//        System.out.println("!!!!!!!!!!!! tabViewChosen "  + tabViewChosen);
//        return tabViewChosen;
//    }

    public boolean isChartEngineChosen()
    {
        return chartEngineChosen;
    }

//    public void setChartEngineChosen(boolean chartEngineChosen)
//    {
//        this.chartEngineChosen = chartEngineChosen;
//    }

    public boolean isContactManagementChosen()
    {
        return contactManagementChosen;
    }

//    public void setContactManagementChosen(boolean contactManagementChosen)
//    {
//        this.contactManagementChosen = contactManagementChosen;
//    }

    public boolean isShopWorkflowChosen()
    {
        return shopWorkflowChosen;
    }

    public boolean isParkingChosen()
    {
        return parkingChosen;
    }

    //    public void setShopWorkflowChosen(boolean shopWorkflowChosen)
//    {
//        this.shopWorkflowChosen = shopWorkflowChosen;
//    }

    public boolean isContactsShown()
    {
        return contactsShown;
    }

    public boolean isMapShown()
    {
        return mapShown;
    }


}
