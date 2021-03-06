/*
 * Anarres C Preprocessor
 * Copyright (c) 2007-2008, Shevek
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.anarres.cpp;

/**
 * A handler for preprocessor events, primarily errors and warnings.
 *
 * If no PreprocessorListener is installed in a Preprocessor, all
 * error and warning events will throw an exception. Installing a
 * listener allows more intelligent handling of these events.
 */
public interface PreprocessorListener {

    /**
     * Handles a warning.
     *
     * The behaviour of this method is defined by the
     * implementation. It may simply record the error message, or
     * it may throw an exception.
     */
    public void handleWarning(Source source, int line, int column,
            String msg)
            throws LexerException;

    /**
     * Handles an error.
     *
     * The behaviour of this method is defined by the
     * implementation. It may simply record the error message, or
     * it may throw an exception.
     */
    public void handleError(Source source, int line, int column,
            String msg)
            throws LexerException;

    public void handleSourceChange(Source source, String event);

    /**
     * Called when preprocessor is about to include file.
     *
     * @param filePath file path
     * @param line     line of include directive
     * @return <code>true</code> if specified file should be skipped,
     * <code>false</code> otherwise
     */
    public boolean beforeInclude(String filePath, int line);

    public void handlePreprocesorDirective(Source source, PreprocessorDirective directive);

    /**
     * @param definitionFileName Can be null in certain cases.
     * @param definitionLine <code>Macro.UNKNOWN_POSITION_VALUE</code> if it is
     *                       unknown, otherwise proper value
     * @param definitionColumn <code>Macro.UNKNOWN_POSITION_VALUE</code> if it
     *                         is unknown, otherwise proper value
     */
    public void handleMacroExpansion(Source source, int line, int column, String macro,
            String definitionFileName, int definitionLine, int definitionColumn);

}
