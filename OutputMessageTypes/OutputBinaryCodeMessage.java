package OutputMessageTypes;

// Import Java API Classes
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OutputBinaryCodeMessage extends OutputMessage {
  
  // Instance Variables
  private String[][] binary_code = new String[26][2];
  private String binary_code_filename = "./Data/BinaryCode_Table.txt";

  // Constructor
  public OutputBinaryCodeMessage(PrintWriter output) throws
                              FileNotFoundException, IOException {
    super(output);
    populateBinaryCode(binary_code_filename);
  }

  // Protected Methods
  
   protected String getLetterWithOrdinal(int ordinal_value) {
  // -----------------------------------------------------------
  // Returns Binary-encoded letter with ordinal value n.
  // (i.e., in nth position of the encodings)
  // -----------------------------------------------------------
    return binary_code[ordinal_value][1];
  }

  // Output Writing Methods
  
  public void writeLetter(int ordinal_value) throws IOException {
  // -----------------------------------------------------------
  // Writes Binary-coded letter to output file with ordinal_value.
  // Throws IOException if output file not open.
  // -----------------------------------------------------------
      writeLine(getLetterWithOrdinal(ordinal_value));
  }
  
  public void writeEndOfWord() throws IOException {
  // -----------------------------------------------------------
  // Writes blank line to output file (for end-of-word)
  // -----------------------------------------------------------
    writeLine("");
  }
  
  public void writeEndOfSentence() throws IOException {
  // -----------------------------------------------------------
  // Writes two blank lines to output file (for end-of-sentence)
  // -----------------------------------------------------------
    writeLine("\n");  
  }
  
  // Private Methods

  private void populateBinaryCode(String file_name) throws
                           FileNotFoundException, IOException {
  // -----------------------------------------------------------
  // Populates binary_code array with the Binary code for the
  // upper-case letters and digits 0-9, read from the text file
  // indicated in binary_code_filename.
  //
  // Throws FileNotFoundException if file not found.
  // Throws IOException if output file not open.
  // -----------------------------------------------------------
    String line;

    // Open Binary code file
    BufferedReader input_file = 
       new BufferedReader(new FileReader(file_name));
    
    // Read first line
    line = input_file.readLine();
    int i = 0;

    // Continue reading lines until end of file
    while(line != null) {

      // Read letter part of Binary code file
      binary_code[i][0] = line.substring(0,1);

      // Read corresponding Binary code of letter
      binary_code[i][1] = line.substring(1, line.length());

      // Read next line of file
      line = input_file.readLine();
      i = i + 1;
    }

    // Close file
    input_file.close();
  }

}