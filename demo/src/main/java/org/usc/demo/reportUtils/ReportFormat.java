package org.usc.demo.reportUtils;


public enum ReportFormat {

    RTF {
        @Override
        public String suffix() {
            return ".rtf";
        }
    },
    CSV {
        @Override
        public String suffix() {
            return ".csv";
        }
    },
    XLS {
        @Override
        public String suffix() {
            return ".xls";
        }
    },
    PDF {
        @Override
        public String suffix() {
            return ".pdf";
        }
    };

    public abstract String suffix();
}
