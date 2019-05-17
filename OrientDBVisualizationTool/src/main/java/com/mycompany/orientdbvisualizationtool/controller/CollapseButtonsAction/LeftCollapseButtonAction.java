package com.mycompany.orientdbvisualizationtool.controller.CollapseButtonsAction;

import com.mycompany.orientdbvisualizationtool.controller.CollapseButtonsAction.CollapseButtonAction;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;


/**
 * Class that defines action taken when left collapse button is clicked.
 */
public class LeftCollapseButtonAction extends CollapseButtonAction {

    /**
     * constructor for collapse button for left pane
     * @param Collapse_Button button for collapsing pane
     * @param Split_Pane pane containing the pane that is to be collapsed
     * @param Collapse_Anchor_Pane pane to be collapsed/expanded
     * @param Center_Anchor_Pane pane centered within split pane
     */
    public LeftCollapseButtonAction(Button Collapse_Button, SplitPane Split_Pane, AnchorPane Collapse_Anchor_Pane, AnchorPane Center_Anchor_Pane) {
        super(Collapse_Button, Split_Pane, Collapse_Anchor_Pane, Center_Anchor_Pane, true);
    }
}
