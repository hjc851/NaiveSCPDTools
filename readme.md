# Naive Source Code Plagiarism Detection Tool Implementations

This repository contains naive implementations of 4 source code plagiarism detection tools. This was created due to an observation that in SCPDT research, tools are not commonly released. Hence, results cannot be replicated. 

The implementations conform to the following category of tools:
* String
* Token
* Tree
* Graph

There is no attempt to optimise these implementations, nor is there any effort to increase their accuracy.

Future reuse of this repository must be within the scope of the provided license.

## String & Token Tools

StringEditDistanceSCPDT and TokenEditDistanceSCPDT evaluate similarity as a function of the edit distance between two files. Edit distance is calculated with Levenshtein Distance.

StringTilingSCPDT and TokenTilingSCPDT are approximations of Greedy String Tiling. It simply attempts to identify substrings of length >= n that can be tiled between two files.

## Tree Tool

Not implemented.

## Graph Tool

Not implemented.

## Utilised Works

Hungarian Algorithm:
https://github.com/KevinStern/software-and-algorithms/