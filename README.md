# Java Arbitrage Finder using Bellman-Ford Algorithm

This Java project provides a tool for finding arbitrage opportunities in a given financial market using 
the Bellman-Ford shortest path algorithm. It operates on a graph represented by an adjacency matrix, making it 
suitable for dense graphs commonly encountered in financial scenarios.

## Table of Contents

- [Introduction](#introduction)
- [Usage](#usage)
- [Algorithm](#algorithm)
- [How to Find a Negative Cycle](#how-to-find-a-negative-cycle)
- [Getting Started](#getting-started)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Financial markets rarely, but sometimes present opportunities for arbitrage, where a trader can profit by 
exploiting price differences between related assets. This Java project aims to identify such opportunities within 
a financial market graph. It utilizes the Bellman-Ford algorithm to find the shortest paths between vertices, 
effectively detecting negative cycles that indicate potential arbitrage opportunities.

## Usage

To use this project, follow these steps:

1. **Instantiate the `Graph` Class:** Create an instance of the `Graph` class, providing the number of vertices, an adjacency matrix representing the graph, and a list of edges.

2. **Run Bellman-Ford Algorithm:** Execute the `bellmanFord` method on your `Graph` object. This algorithm will identify whether there is a negative cycle in the graph, which is a key indicator of arbitrage opportunities.

3. **Find Negative Cycles:** If the `bellmanFord` method returns `true`, indicating the presence of a negative cycle, you can use the `findNegativeCycle` method to locate the vertices within the cycle.

4. **Analyze Arbitrage Opportunities:** Analyze the identified negative cycle to determine the arbitrage opportunity within the financial market.

## Algorithm

This project uses the Bellman-Ford algorithm to find the shortest path estimates between vertices. The algorithm also detects negative cycles, which can indicate potential arbitrage opportunities. Here's a brief overview:

- `bellmanFord`: Executes the Bellman-Ford algorithm and returns `true` if a negative cycle is found, indicating an arbitrage opportunity.

- `findNegativeCycle`: If a negative cycle is detected, this method returns the list of vertices within the cycle.

## How to Find a Negative Cycle

When a negative cycle is detected during the Bellman-Ford algorithm, you can use the `findNegativeCycle` method to locate the vertices within the cycle. This can be a valuable step in identifying and exploiting arbitrage opportunities within the financial market.

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/your-java-arbitrage-project.git



