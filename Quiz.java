//SHUBHAM PALIWAL
//2015B1A70823H


import java.awt.Dimension.*;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class Quiz extends JFrame{
	JButton button1;
		JButton button2,button3,button4,button5,insertbutton,insertTFButton,insertMCQButton,insertfillupButton,backinsertbutton,backTFButton,backMCQbutton,backfillupbutton,backModifybutton,backdeletebutton;
		JTextField textfield1,deleteQuestionNumber;
		JRadioButton Physics,Maths,opt1,opt2;
		JPasswordField passwordfield1;
		JRadioButton trueFalse, fillUps, multipleChoice,choice1,choice2,choice3;
		JTextArea trueFalseQuestion, fillUpsQuestion, multipleChoiceQuestion,textArea1,textarea2,textArea3,deleteQuestionView;
		JTextField   trueFalseAnswer, fillUpsAnswer;
		JTextField  Option1, Option2, Option3, Option4, multipleChoiceAnswer;
		JFrame QuizWindowFrame,InsertoptionFrame,TfFrame,MCQFrame,EditFrame,DeleteFrame,fillupFrame,generateframe;
		JButton deleteQuestionViewButton,deleteQuestionYesButton,generatebutton,backgeneratebutton;
		int buttonClicked;
		int sub,n;
		File fileq = new File("Question.txt");
        File filea = new File("Answer.txt");
	
	public static void main(String[] args)
	{
		new Quiz();
	}
	public Quiz(){
		this.setSize(500,200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("GATEWAY TO QUIZ GENERATOR");
		JPanel thePanel=new JPanel(new GridLayout(3,1));
		JLabel label1=new JLabel("Username");
		thePanel.add(label1);
		textfield1=new JTextField(20);
		thePanel.add(textfield1);
		JLabel label2=new JLabel("Password");
		thePanel.add(label2);
		passwordfield1=new JPasswordField(20);
		thePanel.add(passwordfield1);
		button1=new JButton("LOGIN");
		ListenForButton1 lforbutton=new ListenForButton1();
		button1.addActionListener(lforbutton);
                
		thePanel.add(button1);
		this.add(thePanel);
                this.setVisible(true);
		
		
	}
	private class ListenForButton1 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==button1){
				String s1=textfield1.getText();
				String s2=passwordfield1.getText();
                            if(s1.equals("shubham")&&s2.equals("paliwal"))
				{
					new QuizWindow();
					Quiz.this.setEnabled(false);
                                        Quiz.this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(Quiz.this,"Wrong Credentials","Error",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		}
	}
	public class QuizWindow extends JFrame{
		QuizWindow(){
                        QuizWindowFrame = new JFrame();
			QuizWindowFrame.setSize(400,400);
			QuizWindowFrame.setResizable(false);
			QuizWindowFrame.setLocationRelativeTo(null);
			
			QuizWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			QuizWindowFrame.setTitle("Quiz Generation Window");
			
			JTextField display=new JTextField();
                        display.setText("Please select the subject and the desired action.");
                        display.setBackground(Color.yellow);
                        
                        display.setBounds(50,50,300,35);
                        display.setEditable(false);
                        
			Physics=new JRadioButton("Physics",true);
			Maths=new JRadioButton("Maths");
			ButtonGroup radioGroup=new ButtonGroup();
			radioGroup.add(Physics);
                        radioGroup.add(Maths);
			
                        JPanel panelForRadioButtons = new JPanel();
                        panelForRadioButtons.add(Physics);
                        panelForRadioButtons.add(Maths);
                        panelForRadioButtons.setBounds(50,110,300,30);
                        
                        ListenForButton2 lforbutton=new ListenForButton2();
                        button2=new JButton("Generate Quiz");
                        button2.setBounds(50,255,130,30);
						button2.setToolTipText("Generate question paper");
                        button3=new JButton("Delete");
                        button3.setBounds(50,175,130,30);
						button3.setToolTipText("Let you edit main questions.");
                        button4=new JButton("Edit");
                        button4.setBounds(220,255,130,30);
						button4.setToolTipText("Let you edit the question paper generated.");
                        button5=new JButton("Insert");
                        button5.setBounds(220,175,130,30);
						button5.setToolTipText("Contribute question to subject");
                        button2.addActionListener(lforbutton);
                        button3.addActionListener(lforbutton);
                        button4.addActionListener(lforbutton);
                        button5.addActionListener(lforbutton);
                        
			JPanel thePanel1=new JPanel();//main panel
                        
			QuizWindowFrame.add(display);
                        QuizWindowFrame.add(panelForRadioButtons);
                        QuizWindowFrame.add(button2);
                        QuizWindowFrame.add(button3);
                        QuizWindowFrame.add(button4);
                        QuizWindowFrame.add(button5);
			QuizWindowFrame.add(thePanel1);
			QuizWindowFrame.setVisible(true);
		}
	}
        private class ListenForButton2 implements ActionListener{           //for buttons in quiz generation window
		public void actionPerformed(ActionEvent e){
			if(Physics.isSelected())
			{sub=1;
			}
			if(Maths.isSelected())
			{sub=2;
			}
			if(e.getSource()==button5){                        //button5-to insert
                        new insertingOption();
                        QuizWindowFrame.setVisible(false);
				
                                           
                        }
                        else if(e.getSource()==button2){                  //button2-to generate
                        new generatewindow();
                        QuizWindowFrame.setVisible(false);
			}
                        else if(e.getSource()==button3){                 //button3-to delete
                        new DeleteWindow();
                        }
                        else if(e.getSource()==button4){                 //button4-to edit
                     try
					  {
					
						
						
                        ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "Question.txt");
                        pb.start();
						ProcessBuilder pb1= new ProcessBuilder("Notepad.exe","Answer.txt");
						pb1.start();

					  }
					  catch(Exception e1)
					  {
						
					  
											}
		
		} }
		}
        public class insertingOption extends JFrame{
                insertingOption(){
                       InsertoptionFrame= new JFrame();
                       InsertoptionFrame.setSize(400,400);
                       InsertoptionFrame.setLocationRelativeTo(null);
                       InsertoptionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                       InsertoptionFrame.setTitle("Inserting Options");
                       InsertoptionFrame.setResizable(false);
                       JTextField display=new JTextField();
                       display.setText("Please select the desired action.");
                        
                       display.setBounds(50,50,300,35);
                       display.setEditable(false);
            
                       trueFalse = new JRadioButton("True/False",true);
                       
                       trueFalse.setBounds(50,100,150,30);
                       fillUps = new JRadioButton("Fill in the Blanks");
                            
                       fillUps.setBounds(50,150,150,30);
                       multipleChoice = new JRadioButton("Multiple Choice Questions");
                       
                       multipleChoice.setBounds(50,200,150,30);
            
                       ButtonGroup questionType = new ButtonGroup();
                       questionType.add(trueFalse);
                       questionType.add(fillUps);
                       questionType.add(multipleChoice);      

                        

                       JPanel panelForInsertQuestionFrame = new JPanel();                  
                       
                       insertbutton = new JButton("ADD");
                       insertbutton.setBounds(50,300,100,30);
                       backinsertbutton= new JButton("BACK");
                       backinsertbutton.setBounds(250,300,100,30);
                       
                       ListenForButton3 lforbutton=new ListenForButton3();
                       insertbutton.addActionListener(lforbutton);
                       backinsertbutton.addActionListener(lforbutton);
                       
                       InsertoptionFrame.add(trueFalse);
                       InsertoptionFrame.add(fillUps);
                       InsertoptionFrame.add(multipleChoice);
                       InsertoptionFrame.add(display);
                       InsertoptionFrame.add(insertbutton);
                       InsertoptionFrame.add(backinsertbutton);
                       InsertoptionFrame.add(panelForInsertQuestionFrame);
                        
                       InsertoptionFrame.setVisible(true);
                        
                }
        }
         private class ListenForButton3 implements ActionListener
        {

                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        int value;
                        if(e.getSource()== insertbutton)
                        {
                        if(trueFalse.isSelected())
                        {
                            value = 1;
                            new TrueFalseWindow();
                            InsertoptionFrame.setVisible(false);
                            
                        }
                        else if(fillUps.isSelected())
                        {
                            value = 2;
                            new FillUpsWindow();
                            InsertoptionFrame.setVisible(false);
                        }
                        else if(multipleChoice.isSelected())
                        {
                            value = 3;
                            new MultipleChoiceWindow();
                            InsertoptionFrame.setVisible(false);
                        }
                        
                     }
                        else if(e.getSource()==backinsertbutton)
                        {
                            QuizWindowFrame.setVisible(true);
                            InsertoptionFrame.setVisible(false);
                        }
            }
        
        }
         private class TrueFalseWindow extends JFrame
        {
                    public TrueFalseWindow()
                    {
                        TfFrame = new JFrame();
                        TfFrame.setSize(400,400);
                        TfFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        TfFrame.setLocationRelativeTo(null);
                        TfFrame.setTitle("Insert True/False");
                        TfFrame.setResizable(false);
            
                        JPanel panelForTrueFalse = new JPanel();                  
                        
          
            
                        trueFalseQuestion = new JTextArea("Question");
                        trueFalseQuestion.setBounds(50,50,300,35);
                        trueFalseQuestion.setBackground(Color.white);
                        trueFalseQuestion.setLineWrap(true);
                        trueFalseQuestion.setWrapStyleWord(true);
            
                        
            
                        
                         
                        insertTFButton = new JButton("INSERT");
                        insertTFButton.setBounds(50,310,100,30);
                        backTFButton= new JButton("BACK");
                        backTFButton.setBounds(250,310,100,30);
						ButtonGroup a=new ButtonGroup();
						opt1=new JRadioButton("True",true);
						opt1.setBounds(50,100,150,40);
						opt2=new JRadioButton("False");
						opt2.setBounds(50,150,150,40);
						a.add(opt1);
						a.add(opt2);
                        ListenForButton4 lforbutton = new ListenForButton4(); //for buttons on tfwindow 
                        insertTFButton.addActionListener(lforbutton);
                        backTFButton.addActionListener(lforbutton);
                        
                        
                        
                        TfFrame.add(trueFalseQuestion);
                       
                        TfFrame.add(insertTFButton);
                        TfFrame.add(backTFButton);
						TfFrame.add(opt1);
						TfFrame.add(opt2);
                        TfFrame.add(panelForTrueFalse);
                        TfFrame.setVisible(true);
            }
        }
         private class ListenForButton4 implements ActionListener
        {

                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        int value;
                        if(e.getSource()== insertTFButton)
                        {
							JOptionPane.showMessageDialog(TfFrame,"SUCCESSFUL");
            
            
            try
            {

            PrintWriter writerq ;
            if(sub==1)
             writerq = new PrintWriter(new FileOutputStream(new File("physicsquestion.txt"), true));

            else
              writerq=new PrintWriter(new FileOutputStream(new File("mathquestion.txt"), true));
			writerq.append("\n");
            writerq.append(trueFalseQuestion.getText());
           
            writerq.close();
          }
          catch(Exception ex)
          {}

        try
        {

            PrintWriter writera ;
            if(sub==1)
              writera=new PrintWriter(new FileOutputStream(new File("physicsanswer.txt"), true));
            else
              writera= new PrintWriter(new FileOutputStream(new File("mathanswer.txt"), true));
				 writera.append("\n");
              if(opt1.isSelected())
                  writera.append("TRUE");
              else if(opt2.isSelected())
                  writera.append("FALSE");


              
              writera.close();

            }
            catch(Exception ex)
            {}
                        }
                        else if(e.getSource()==backTFButton)
                        {
                            TfFrame.setVisible(false);
                            InsertoptionFrame.setVisible(true);
                            
                        }    
            }
        
        }
         
         private class MultipleChoiceWindow extends JFrame
        {
                    public MultipleChoiceWindow()
                {
                        MCQFrame=new JFrame();
                        MCQFrame.setSize(400,400);
                        MCQFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        MCQFrame.setLocationRelativeTo(null);
                        MCQFrame.setTitle("Insert MCQ");
                        MCQFrame.setResizable(false);

                        JPanel panelForMultipleChoice = new JPanel();                  
                        

                        JTextArea textArea1 = new JTextArea();
                        textArea1.setText("Write the question in the box below");
                        textArea1.setLineWrap(true);
                        textArea1.setWrapStyleWord(true);
                        textArea1.setBounds(50,30,300,20);
                        
                        textArea1.setEditable(false);

                        multipleChoiceQuestion = new JTextArea();
                        multipleChoiceQuestion.setBounds(50,60,300,70);
                        multipleChoiceQuestion.setBackground(Color.white);
                        multipleChoiceQuestion.setLineWrap(true);
                        multipleChoiceQuestion.setWrapStyleWord(true);

                        JTextArea textArea2 = new JTextArea();
                        textArea2.setText("Write the four options in the boxes below");
                        textArea2.setLineWrap(true);
                        textArea2.setWrapStyleWord(true);
                        textArea2.setBounds(50,150,300,20);
                        
                        textArea2.setEditable(false);

                        Option1 = new JTextField("",10);
                        Option1.setBounds(35,180,150,30);

                        Option2 = new JTextField("",10);
                        Option2.setBounds(215,180,150,30);

                        Option3 = new JTextField("",10);
                        Option3.setBounds(35,220,150,30);

                        Option4 = new JTextField("",10);
                        Option4.setBounds(215,220,150,30);

                        JTextArea textArea3 = new JTextArea();
                        textArea3.setText("Write the correct answer in the box below");
                        textArea3.setLineWrap(true);
                        textArea3.setWrapStyleWord(true);
                        textArea3.setBounds(50,260,300,20);
                        
                        textArea3.setEditable(false);

                        multipleChoiceAnswer = new JTextField("",10);
                        multipleChoiceAnswer.setBounds(50,290,300,30);

                        insertMCQButton = new JButton("INSERT");
                        insertMCQButton.setBounds(50,330,100,30);
                        backMCQbutton = new JButton("BACK");
                        backMCQbutton.setBounds(250,330,100,30);
                        ListenForButton5 lforbutton=new ListenForButton5();
                        backMCQbutton.addActionListener(lforbutton);
                        insertMCQButton.addActionListener(lforbutton);
                        
                        MCQFrame.add(textArea1);
                        MCQFrame.add(textArea2);
                        MCQFrame.add(multipleChoiceQuestion);
                        MCQFrame.add(Option1);
                        MCQFrame.add(Option2);
                        MCQFrame.add(Option3);
                        MCQFrame.add(Option4);
                        MCQFrame.add(textArea3);
                        MCQFrame.add(multipleChoiceAnswer);
                        MCQFrame.add(insertMCQButton);
                        MCQFrame.add(backMCQbutton);
                        MCQFrame.add(panelForMultipleChoice);
                        MCQFrame.setVisible(true);
                }
        }
          private class ListenForButton5 implements ActionListener
        {

                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        int value;
                        if(e.getSource()== insertMCQButton)
                        {
						   JOptionPane.showMessageDialog(MCQFrame,"SUCCESSFUL");
						
						  try
						  {

						  PrintWriter writerq ;
						  if(sub==1)
						   writerq = new PrintWriter(new FileOutputStream(new File("physicsquestion.txt"), true));
							//writerq=new PrintWriter("physicsquestion.txt",true);
						  else
							writerq=new PrintWriter(new FileOutputStream(new File("mathquestion.txt"), true));
					      writerq.append("\n");
						  writerq.append(multipleChoiceQuestion.getText());
						  writerq.append("   A. "+Option1.getText());
						  writerq.append("   B. "+Option2.getText());
						  writerq.append("   C. "+Option3.getText());
						  writerq.append("   D. "+Option4.getText());
						  
						  writerq.close();
						}
						catch(Exception ex)
						{}


						try
						{

						PrintWriter writera ;
						  if(sub==1)
							writera=new PrintWriter(new FileOutputStream(new File("physicsanswer.txt"), true));
						  else
							writera= new PrintWriter(new FileOutputStream(new File("mathanswer.txt"), true));

						 
						  writera.append("\n");
						  writera.append(multipleChoiceAnswer.getText());
						  
						  writera.close();
						}
						  catch(Exception ex)
						  {      }

    
						}
                        else if(e.getSource()==backMCQbutton)
                        {
                            MCQFrame.setVisible(false);
                            InsertoptionFrame.setVisible(true);
                            
                        }    
            }
        
        }
         private class FillUpsWindow extends JFrame
        {
                public FillUpsWindow()
            {       fillupFrame=new JFrame();
                    
                    fillupFrame.setSize(400,400);
                    fillupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    fillupFrame.setLocationRelativeTo(null);
                    fillupFrame.setTitle("Insert Fill Up");
                    fillupFrame.setResizable(false);

                    JPanel panelForFillUpsFrame = new JPanel();                  
                    

                    JTextArea textArea1 = new JTextArea();
                    textArea1.setText("Write the question in the box below");
                    textArea1.setLineWrap(true);
                    textArea1.setWrapStyleWord(true);
                    textArea1.setBounds(50,50,300,20);
                    textArea1.setBackground(Color.yellow);
                    textArea1.setEditable(false);

                    fillUpsQuestion = new JTextArea();
                    fillUpsQuestion.setBounds(50,80,300,130);
                    fillUpsQuestion.setBackground(Color.white);
                    fillUpsQuestion.setLineWrap(true);
                    fillUpsQuestion.setWrapStyleWord(true);

                    JTextArea textArea2 = new JTextArea();
                    textArea2.setText("Write the answer in the box below");
                    textArea2.setLineWrap(true);
                    textArea2.setWrapStyleWord(true);
                    textArea2.setBounds(50,230,300,20);
                    textArea2.setBackground(Color.yellow);
                    textArea2.setEditable(false);

                    fillUpsAnswer = new JTextField("",10);
                    fillUpsAnswer.setBounds(50,260,300,30);
                    ListenForButton6 lforbutton=new ListenForButton6();
                    
                    
                    insertfillupButton = new JButton("INSERT");
                    insertfillupButton.addActionListener(lforbutton);
                    insertfillupButton.setBounds(50,310,100,30);
                    backfillupbutton = new JButton("BACK");
                    backfillupbutton.addActionListener(lforbutton);
                    backfillupbutton.setBounds(250,310,100,30);

                    fillupFrame.add(textArea1);
                    fillupFrame.add(textArea2);
                    fillupFrame.add(fillUpsQuestion);
                    fillupFrame.add(fillUpsAnswer);
                    fillupFrame.add(insertfillupButton);
                    fillupFrame.add(backfillupbutton);
                    fillupFrame.add(panelForFillUpsFrame);
                    fillupFrame.setVisible(true);
        }
    }
         private class ListenForButton6 implements ActionListener
        {

                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        int value;
                        if(e.getSource()== insertfillupButton)
                        {
	                         try
							{

							PrintWriter writerq,writera ;
							if(sub==1)
							 {
							   writerq = new PrintWriter(new FileOutputStream(new File("physicsquestion.txt"), true));
							   writera = new PrintWriter(new FileOutputStream(new File("physicsanswer.txt"), true));
							 }
							else
							  {
								writerq= new PrintWriter(new FileOutputStream(new File("mathquestion.txt"), true));
								writera= new PrintWriter(new FileOutputStream(new File("mathanswer.txt"), true));
							  }
							  writerq.append("\n");
							writerq.append(fillUpsQuestion.getText());
							
							writerq.close();
							writera.append("\n");
							writera.append(fillUpsAnswer.getText());
							
							writera.close();
							JOptionPane.showMessageDialog(fillupFrame,"SUCCESSFUL"); 
							

						  }
						  catch(Exception ex)
						  {}
                        }
                        else if(e.getSource()==backfillupbutton)
                        {
                            fillupFrame.setVisible(false);
                            InsertoptionFrame.setVisible(true);
                            
                        }    
            }
        
        }
          private class DeleteWindow extends JFrame
    {
                public DeleteWindow()
                {
                    try
					  {
					
						
						if(sub==1)
                        {ProcessBuilder pb2 = new ProcessBuilder("Notepad.exe", "physicsquestion.txt");
                        pb2.start();
						ProcessBuilder pb3= new ProcessBuilder("Notepad.exe","physicsanswer.txt");
						pb3.start();}
						else
						{
						ProcessBuilder pb2 = new ProcessBuilder("Notepad.exe", "mathquestion.txt");
                        pb2.start();
						ProcessBuilder pb3= new ProcessBuilder("Notepad.exe","mathanswer.txt");
						pb3.start();
						}

					  }
					  catch(Exception e1)
					  {
						
					  
											}
             
                }
            }
          public class generatewindow extends JFrame
          {
              public generatewindow(){
                generateframe=new JFrame();
                 
                generateframe.setSize(400,400);
                generateframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                generateframe.setLocationRelativeTo(null);
                generateframe.setTitle("Generate Quiz");
                generateframe.setResizable(false);
                JTextField display=new JTextField();
                display.setText("SELECT NUMBER OF QUESTIONS");
                        
                display.setBounds(50,50,300,35);
                display.setEditable(false);
                
                choice1 = new JRadioButton("5",true);
                choice2 = new JRadioButton("10");
                choice3 = new JRadioButton("15");
                choice1.setBounds(50,100,150,30);
                choice2.setBounds(50,150,150,30);
                choice3.setBounds(50,200,150,30);
                generatebutton =new JButton("GENERATE");
                generatebutton.setBounds(50,310,100,30);
                backgeneratebutton=new JButton("BACK");
                backgeneratebutton.setBounds(250,310,100,30);
                JPanel generatepanel = new JPanel();
                ButtonGroup radioGroup=new ButtonGroup();
	        radioGroup.add(choice1);
                radioGroup.add(choice2);
                radioGroup.add(choice3);
                ListenForButton7 lforbutton=new ListenForButton7();
                generatebutton.addActionListener(lforbutton);
                backgeneratebutton.addActionListener(lforbutton);
                
                
                generateframe.add(choice1);
                generateframe.add(choice2);
                generateframe.add(choice3);
                generateframe.add(choice3);
                generateframe.add(generatebutton);
                generateframe.add(backgeneratebutton);
                generateframe.add(display);
                
                generateframe.add(generatepanel);
                
                generateframe.setVisible(true);
                
                
                
                

                  
              }
                      
          }
          private class ListenForButton7 implements ActionListener          //for generate button
        {

                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {   
                        int value;
						 
                        if(e.getSource()== generatebutton)
                        {JOptionPane.showMessageDialog(fillupFrame,"SUCCESSFUL");
                        if(choice1.isSelected())
                        {
                          
                            n=5;
                        }
                        else if(choice2.isSelected())
                        {
                         n=10;  
                        }
                        else if(choice3.isSelected())
                        {
                         n=15;   
                        }
						try{generate();}
						catch(Exception a2e){}
						
                        
                     }
                        else if(e.getSource()==backgeneratebutton)
                        {
                            QuizWindowFrame.setVisible(true);
                            generateframe.setVisible(false);
                        }
            }
        
        }
				void generate()throws IOException
			{

				  BufferedReader q,a;
				  PrintWriter writerq = new PrintWriter("Question.txt", "UTF-8");
				  PrintWriter writera = new PrintWriter("Answer.txt", "UTF-8");

				  if(n>20)
					n=20;

				  if(sub==1)
				  {

						q  = new BufferedReader(new FileReader("physicsquestion.txt"));
						a  = new BufferedReader(new FileReader("physicsanswer.txt"));

				  }

				  else
				  {
					  q  = new BufferedReader(new FileReader("mathquestion.txt"));
					  a  = new BufferedReader(new FileReader("mathanswer.txt"));
				  }


			   Random random = new Random();
				ArrayList<Integer> lineNo = new ArrayList<Integer>();

				  for (int i = 0; i < 20; i++)
					lineNo.add(i);

					Collections.shuffle(lineNo);

					for (int i = 19; i > n-1 ; i--)
					  lineNo.remove(i);


				   Collections.sort(lineNo);

				   String info = "";


				   writerq.println("QUESTION :");

				   for (int i = 0,c=0; i < 20; i++)
				   { if(lineNo.contains(i))
					  {
						  info = q.readLine();
						  writerq.println((++c)+". "+info);
						}

					  else
						  info = q.readLine();


					}


				writera.println("ANSWER :");

				  for (int i = 0,c=0; i < 20; i++)
				  {
					if(lineNo.contains(i))
					 {
						 info = a.readLine();
						 writera.println((++c)+". "+info);
					   }

					   else
						   info = a.readLine();

				   }

				   q.close();
				   a.close();
				   writerq.close();
				   writera.close();


			}
			
	
}