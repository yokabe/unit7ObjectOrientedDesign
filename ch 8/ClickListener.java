import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener
{
    private int count;
    private String string;
    
    public ClickListener()
    {
        
    }
    
    public void actionPerformed( ActionEvent event )
    {
        label.setText(event.getActionCommand());
    }
}
