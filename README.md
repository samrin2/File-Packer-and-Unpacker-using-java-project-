

# Java File Packer and Unpacker

This Java project provides a simple file packing and unpacking utility. It allows users to combine multiple files into a single packed file and later extract the original files from the packed file.

## Features

- **File Packing**: Combine multiple files into a single packed file.
- **File Unpacking**: Extract original files from a packed file.
- **Simple Command-Line Interface**: Easy-to-use command-line interface for packing and unpacking files.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your system.
- Basic understanding of the command line.

### Installation

1. Clone the repository to your local machine:

    ```
    git clone:[https://github.com/samrin2/File-Packer-and-Unpacker-using-java-project-.git]
    ```

2. Compile the Java source files:

    ```
    javac FilePacker.java FileUnpacker.java
    ```

### Usage

#### Packing Files

To pack files into a single packed file, use the following command:

```
java FilePacker packed_file_name input_file1 input_file2 ...
```

Replace `packed_file_name` with the desired name of the packed file and `input_file1`, `input_file2`, etc., with the paths to the files you want to pack.

#### Unpacking Files

To unpack files from a packed file, use the following command:

```
java FileUnpacker packed_file_name output_directory
```

Replace `packed_file_name` with the path to the packed file and `output_directory` with the directory where you want to extract the files.

